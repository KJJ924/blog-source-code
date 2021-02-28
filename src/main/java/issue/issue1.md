## File 및 Data 를 같이 처리할때 통일 rest Api 규칙 



시간이 소중한 개발자들을 위해 먼저 **결론**은 

```java
@PostMapping
public ResponseEntity<UsedItem> save(
    @Valid @RequestBody SaveUsedItemRequest saveUsedItemRequest,
    @RequestParam(required = false) MultipartFile file) {
  UsedItem usedItem = usedItemService.save(saveUsedItemRequest, file);
  return new ResponseEntity<>(usedItem, HttpStatus.CREATED);
}
```

다음과같이 save(**@RequestBody T t** , **@RequestParam MultipartFile file**)로 따로 보내는걸로 합의했습니다.





## 시도했던 방법들.



@RequestBody 로 요청을 받을시 MultipartFile 객체를 바인딩을 할 수 없습니다.



따라서  



기존사용하고있던 SaveUsedItemRequest 와 MutipartFile  을 합친 클래스를 하나 정의합니다.

 

```java
@Getter
@Setter
public class FileAndUsedItemRequest {
  private SaveUsedItemRequest saveUsedItemRequest;
  private MultipartFile file;

}
```



새로운 그릇을 만들었으니 컨트롤러는 다음과 같이 변경되겠습니다.

```java
@PostMapping
public ResponseEntity<UsedItem> save(@Valid @RequestParam FileAndUsedItemRequest request) {
  UsedItem usedItem = usedItemService.save(request);
  return new ResponseEntity<>(usedItem, HttpStatus.CREATED);
}
```



이런식으로 하면 따로 따로 받지않고 한번에 처리 할 수 있지만?

<img src="https://user-images.githubusercontent.com/64793712/109421103-48dac500-7a19-11eb-8261-45946868a95b.png" alt="image" style="zoom:80%;" />



@Valid 가 동작하지 않아서 데이터 검증을 하지 못합니다.

->동작을 하지 않기때문에 저희가 직접 검증하는 로직을 따로 만들면 되긴 합니다.  

<u>ex) 다음과 같은 메서드를 하나 만들고 validation(request.getSaveUsedItemRequest) 해당 메서드 내에서 각각의 필드에 대한  검증로직을 작성하면됩니다.</u> 





생각만 했던 2번째 방법.



이미지를 나타내는 방식은 크게 data URL  vs Image file  이 있는데.

기존 사용하는 image file 형식이아닌 

data URL 은 값 자체가 String 형 임으로 하나의 요청으로 받아서 처리 할 수 있습니다.



하지만 파일의 용량이 커지는 문제와 캐싱이 되지않는 문제가 있습니다. 자세한 단점들은 [여기서](https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/Data_URIs)



따라서 다음 방법도 사용하지 않는걸로..



