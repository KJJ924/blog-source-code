# [Spring boot] 여러 필드를 검사하기위한 Custom Valid Annotation 만들기



## intro

스프링 컨트롤러에서 클라이언트로부터 받은 값을 검증하기위해 Validation을 많이 사용하곤 합니다.

기본적으로  JSR 380이 제공해주는 [Bean Validation 의 종류](https://www.baeldung.com/javax-validation)는 다양하지만 
각자의 서비스에 따라 기본적으로 제공해주는 애노테이션만으로는 검증을 모두다 지원해주지는 못합니다.

따라서 상황에 따라 각 서비스에 맞는 커스텀한 Validation을 만들어서 활용하기도합니다.

그렇다면 이번글에서는 왜 커스텀 Validation 을 만들었고 만드는 과정을 소개하고자합니다.



## 왜 필요한가?

기존 `@NotNull, @NotEmpty, @NotBlank, @Email` 등의 애노테이션으로  클라이언트 요청으로 값을 검증하는것은

필드 자체의 형식이나 값을 체크하는 용도로만 사용됩니다. 

즉 필드 와 필드 를 비교하여 검증하는 로직이 서비스 로직에 포함되는 경우가 발생하게 됩니다.



**예시**

 `예약시간` , `예약종료시간` 이라는 필드가 존재할때 기본적으로 예약시간이 예약종료시간보다 늦을 수는 없습니다.

결국  `예약시간` , `예약종료시간` 이 알맞게 들어왔는지 확인하기위해 다음과 같은 코드를 작성하게됩니다.

```java
if (reservationStart.isAfter(reservationEnd)){
  //TODO Exception
} 
```

과연 이러한 코드는 비지니스 로직에 몇번이나 포함이 될까요?

예약을 저장, 예약시간을 변경, 선택 시간 범위내 존재하는 예약리스트 반환 등등 클라이언트로 요청이 넘어온 `예약시간` , `예약종료시간`  필드들은 항상 검증을 해야합니다.

이러한 방법은 어쩔수 없이 중복코드를 발생시키고 까먹고 검증과정을 누락하여 버그를 발생시킬수 있습니다.

또한 이러한 검증로직이 서비스 레이어까지 내려오는것이 맞을까요? 

단순히 입력값 자체를 비교하는 과정은 조금더 외부 Layer 에서 처리하는것이 좋을 것 같습니다.



## Custom Valid Annotation 만들기



클라이언트로 받을 DTO 는 다음과 같습니다.

```java
@StartAndEndTimeCheck(startDate = "reservationStart", endDate = "reservationEnd") //해당 애노테이션을 만들고자합니다.
public class RequestOrder {

    @NotBlank
    @ApiModelProperty(value = "메뉴이름", required = true, example = "다운펌")
    private String menuName;

    @NotBlank
    @ApiModelProperty(value = "회원 전화번호", required = true, example = "01012345678")
    private String memberPhoneNumber;

    @NotBlank
    @ApiModelProperty(value = "디자이너 이름", required = true, example = "디자이너")
    private String designerName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    @ApiModelProperty(value = "예약 시작시간", required = true, example = "2021-06-16T11:40")
    private LocalDateTime reservationStart; // 필드 비교 대상

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    @ApiModelProperty(value = "예약 끝나는시간", required = true, example = "2021-06-16T12:40")
    private LocalDateTime reservationEnd; // // 필드 비교 대상

}
```

저희의 목적은 `@Valid` 를 이용하여 기존 서비스 로직에 존재하는 검증로직을 제거하는 것이 목표입니다.



### @StartAndEndTimeCheck 만들기

```java
@Target(ElementType.TYPE) 
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartAndEndTimeCheckValidator.class)
public @interface StartAndEndTimeCheck {

    String message() default "에약시작 시간이 예약종료 시간 보다 늦을수 없습니다.";  // 예외가 발생하면 출력할 메세지

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  
    String startDate(); // 대상 객체의 시작시간 필드 이름을 담을 그릇

    String endDate(); // 대상 객체의 종료시간 필드 이름을 담을 그릇
}
```

사용할 커스텀한 애노테이션을 만듭니다.

이제 커스텀 애노테이션을 만들었으니 작동할 validator 를 생성하면 끝입니다.



### StartAndEndTimeCheckValidator

```java
public class StartAndEndTimeCheckValidator implements ConstraintValidator<StartAndEndTimeCheck, Object> {
    private String message;
    private String startDate;
    private String endDate;
  
    @Override
    public void initialize(StartAndEndTimeCheck constraintAnnotation) {
        message = constraintAnnotation.message();  // 애노테이션에 저장된 메세지
        startDate = constraintAnnotation.startDate(); // 애노테이션에 저장된 비교할 필드
        endDate = constraintAnnotation.endDate(); // 애노테이션에 저장된 비교할 필드
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        try {
            LocalDateTime reservationStart = (LocalDateTime) getFieldValue(o, startDate);
            LocalDateTime reservationEnd = (LocalDateTime) getFieldValue(o, endDate);
            if (reservationStart.isAfter(reservationEnd)) { // 검증 후 오류가 있다면
                context.disableDefaultConstraintViolation();  
                context.buildConstraintViolationWithTemplate(message) //context에 오류메세지와 
                    .addPropertyNode(startDate) //대상 필드를 넣어줍니다.
                    .addConstraintViolation();
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

 	 // 리플렉션을 이용하여 필드를 가져옴 
    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();  //
        Field dateField = clazz.getDeclaredField(fieldName);
        dateField.setAccessible(true);
        return dateField.get(object);
    }
}
```

`ConstraintValidator<StartAndEndTimeCheck, Object>` 여기서 왜 Object 형태를 사용하는가? 
해당 애노테이션을 어떠한 <u>특정 DTO 에 종속되게 사용하지 않고 범용적으로 재활용하기위해서 Object 형태로 받았습니다.</u>



따라서 Object 형태로는 필드의 값을 가져오지못해 

`@StartAndEndTimeCheck(startDate = "reservationStart", endDate = "reservationEnd")`

리플랙션을 이용하여  특정 필드의 값을 가져올 수 있도록 하기위해서 위 처럼 애노테이션으로 대상 필드 Name 을 받았습니다.



## 사용 

사용법은 간단합니다. 

해당 커스텀 애노테이션의 값에 대상 필드를 작성합니다
(Type safe 하지 않다는 단점이 존재하네요 필드 철자가 틀리면 오류가 발생합니다. )

```java

@StartAndEndTimeCheck(startDate = "reservationStart", endDate = "reservationEnd")
public class RequestOrder {
  //생략
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;

}

@StartAndEndTimeCheck(startDate = "reservationStart", endDate = "reservationEnd")
public class RequestOrderTimeEdit {
    private Long id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
}

```



컨트롤러에 @Valid 를 붙여 검증을하시면 됩니다.

```java
@PostMapping("/order")
@ApiOperation(value = "예약 추가", notes = "예약 일정을 생성합니다.")
//@Valid 애노테이션으로 검증
public ResponseEntity<ResponseOrder> createOrder(@RequestBody @Valid RequestOrder requestOrder) { 
    ResponseOrder order = orderService.saveOrder(requestOrder);
    return ResponseEntity.ok(order);
}
```





## 오류 발생시 응답 결과



**요청** 

```json
Request Post /order
{
  "designerName": "디자이너",
  "memberPhoneNumber": "01012345678",
  "menuName": "다운펌",
  "reservationEnd": "2021-06-16T12:40",  
  "reservationStart": "2021-06-16T13:40"  // 현재 시작시간이 종료시간보다 늦습니다  
}
```



**응답**

![image-20210625201658992](https://tva1.sinaimg.cn/large/008i3skNgy1gruq9ah8zdj312t0bnwfv.jpg)

해당 오류 응답처럼 내보내기 위해 저는 GlobalExceptionController 를 만들어서 처리하였습니다.

[프로젝트](https://github.com/KJJ924/hair_shop_managing_system/tree/master/src/main/java/hair_shop/demo/error)를 확인해주세요 !



## 결론

클라이언트가 요청한 내부의 단순 값 과 값의  비교에 따라 비지니스 로직처리가 필요한 경우 

Service Layer 에서 일일이 검증하는것보다는 Custom Valid Annotation 을 이용해보는 것도 좋을것 같습니다.



긴 글 읽어주셔서 감사합니다.

본문에 존재하는 오류나 질문은 댓글로 남겨주세요!