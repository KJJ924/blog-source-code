​	목표

자바의 람다식에 대해 학습하세요.

# 학습할 것 (필수)

- 람다식 사용법
- 함수형 인터페이스
- Variable Capture
- 메소드, 생성자 레퍼런스







## 람다식 사용법



자바 8 이후부터 **인터페이스 내에 추상메서드가 단 하나만 존재하게** 되면 람다표현식을 사용 할 수 있다.

```java
@FunctionalInterface
public interface Foo {
    void Hello(String msg); // abstract 생략되어있습니다. 이제 다아시죠..?
}
```

다음과 같이 <u>인터페이스 내에 추상메서드가 단 하나만 존재하는 인터페이스를</u> **함수형 인터페이스**라고 말합니다. 



그럼 함수형 인터페이스를 지원하기전 즉 자바 8 이전에는 무엇을 사용했을까요 ?



다음과 같이 **익명클래스** 를 사용했습니다.

```java
public static void main(String[] args) {
    Foo foo = new Foo() {
        @Override
        public void Hello(String msg) {
            System.out.println(msg);
        }
    };

    foo.Hello("마지막 주차 ..");
}
```

익명클래스 방식은 간결하지 못하며 가독성이 떨어지는 단점이 있습니다.(<u>그렇다고 무조건 람다만 사용하는것은 아닙니다.</u>)



하지만 람다를 사용하게 된다면 위와 같은행동을 하는 코드는 다음과 같이 변화하게 됩니다.

```java
public static void main(String[] args) {
  Foo foo = (String msg) ->{
    System.out.println(msg);
  };
  foo.Hello("마지막 주차 ..");
}
```

람다식의 구문은 ( 파라미터) -> { 표현식 } 입니다.



별 차이점이 없어보이지만?  이보다 더 축약이 가능합니다. 

현재는 급격하게 변화하면 이해가 힘드니 한 단계씩 알아가보죠.



람다표현식을 사용하게 되면 <u>타입을 생략</u> 할 수 있는데 <u>컴파일러가 대신 인터페이스에 대한 타입추론</u>을 대신해주기 때문입니다.



위와 같은 이유로 현재 메서드에 파라미터로 들어가는

```java
void Hello(String msg);
```

msg 의 타입인 String을 생략할 수 있게됩니다.



따라서 람다표현식은 다음처럼 한단계 더 축약할 수 있게됩니다.

```java
public static void main(String[] args) {
    Foo foo = (msg) ->{ // 타입추론은 컴파일러가!
        System.out.println(msg);
    };

    foo.Hello("마지막 주차 ..");
}
```

어떤가요? 아직도 좀 긴거 같습니다.



한 단계 더 나아가보죠.



현재 <u>(msg)</u> -> {출력문} 이라는 형태를 가지고 있는데.



**메서드의 파라미터가 1개 이면 위에서 제가 밑줄친 부분의 괄호( ''(...)" )를 생략**이 가능합니다.

```java
public static void main(String[] args) {
    Foo foo = msg ->{ //메서드에서 받는 파라미터가 한 개 임으로 생략가능 !
        System.out.println(msg);
    };

    foo.Hello("마지막 주차 ..");
}
```

메서드의 파라미터가 1개 초과 이면 즉 2개 이상부터는 괄호 를 생략하지 못합니다,



아직도 좀 긴거 같습니다.



한 단계 더 줄여보죠.



현재상태는 다음과 같습니다.  msg -> <u>{출력문}</u> 



{출력문} 즉 표현식 부분에서 한 가지의 행동만 한다면 코드블럭( {  } ) 을 생략할 수 있습니다.

```java
public static void main(String[] args) {
    Foo foo = msg -> System.out.println(msg); // 코드블럭 생략
    foo.Hello("마지막 주차 ..");
}
```

만약 추가로직을 더 추가하고 싶다면 코드블럭 내에 추가할 로직들을 사용하면됩니다.



```java
public static void main(String[] args) {
    Foo foo = msg ->{
        System.out.println("아쉽지만.."); // 추가로직
        System.out.println(msg);;
    };

    foo.Hello("마지막 주차 ..");
}
```



현재 `Foo foo = hi -> System.out.println(hi);`  까지 축약이 되었습니다.

저는 사실 여기까지만 해도 만족하지만.



**메서드 레퍼런스** 를 통해 마지막으로 한번 더 줄일수 있습니다.

```java
public static void main(String[] args) {
  Foo foo = System.out::println; //메소드 레퍼런스 사용
  foo.Hello("마지막 주차 ..");
}
```



**메서드 레퍼런스** 의 문법은 다음과 같으며

클래스이름::메소드이름 (ex. System.out::println)

참조변수이름::메소드이름



파라미터를 생략할 수 있게 해준다.

예제를 살펴보면

`System.out.println()` 출력하기 위해 한개의 파라미터를 받게 됩니다.

함수  `msg ->System.out.println(msg)` 는. 한개의 파라미터가 넘어오는 것을 알고

파라미터의 타입은 컴파일러가 추론하게 해주고

메서드 레퍼런스를 이용하게 되면 파라미터를 생략 할 수 있음으로   

`Foo foo = System.out::println;` 과 같이 많은 생략이 가능합니다.



사실 저는 메서드 레퍼런스 같은 경우 처음부터 의도해서 사용해본적은 단 한번도 없고

일단 람다식을 작성하고 IDE가 변경을 추천해주면 한번 변경해보고 마음에들면 사용합니다.

(모든 메서드를 알고 있을수는 없기 때문에)





## 함수형 인터페이스

앞서 시작부분에서 함수형 인터페이스가 무엇인지 언급을 했기 때문에 자세한 설명은 생략을 하고



`@Override` 처럼 컴파일타임에 체크할수 있는 <u>함수형 인터페이스를 보장 해주기 위한 애노테이션</u>이 있습니다.

```java
@FunctionalInterface
```

해당 애노테이션은 인터페이스 내에 추상메서드가 2 개 이상 존재할 때 컴파일 에러를 보여줍니다.

![image](https://user-images.githubusercontent.com/64793712/110106764-6cbd5280-7ded-11eb-9205-4c9229009f86.png)



자바 진영에서 제공하는 표준 함수형 인터페이스 목록

https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html





## Variable Capture



컴파일 시점에 멤버 메서드의 매개변수나 지역 변수를 멤버 메서드 내부에서 생성한 객체가 사용 할 경우 <u>객체 내부로 값을 복사해서 사용한다</u>.



객체 내부로 값을 복사하기 위해선 제약 조건이 생기는데 복사의 대상은 final 키워드로 선언이 되어 있거나

Final 키워드로 선언이 되어 있지 않아도 값 자체가 한 번만 할당 되어 사용되어야 한다.



이러한 행위를 하는 이유

함수를 실행을 완료하고 모든 변수가 소멸된 상태에서 프로세스 스택에서 제거 될 수 있지만 내부 클래스의 객체가 해당 함수의 특정 지역변수를 참조하면 힙에 남아 있을수 있기 때문이다.

[자세한 이유](http://www.devcodenote.com/2015/04/variable-capture-in-java.html)



간단하게

1. 람다식은 익명클래스 처럼 별도의 객체를 생성하거나 별도의 클래스를 생성하지 않는다

2. 람다식 내부에서 사용하는 변수는 Variable Capture 가 발생하며, 이 값은 final 이거나 final 처럼 사용 해야한다!



여기 아주 상세하게 나와있어욥 [참고](https://blog.naver.com/hsm622/222260183401)











