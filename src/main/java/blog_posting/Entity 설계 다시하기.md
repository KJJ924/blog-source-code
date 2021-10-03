# Entity 설계 다시하기



해당 [프로젝트](https://github.com/SEONGNAM-SELLDOK/damoim-api)를 진행한지 좀 오래되었지만 정리는 꼭 해야된다고 생각하여

좀 많이 늦은감이 있지만 이제라도 작성해봅니다. ㅜ.ㅜ



## 왜 잘못된 설계를 했는가?

프로젝트의 게시판의 종류는 중고나라, 도서리뷰, 구인구직, 강의 등이 존재한다.

![image-20210623174052330](https://tva1.sinaimg.cn/large/008i3skNgy1grsai8y3dlj30uu0az76a.jpg)

현재 Entity 의 설계는 게시판 종류별 로  Table 을 가지는 형태이다.

`왜 이렇게 설계 했는가?` 그때 당시를 생각해보면..

팀원별 각자의 도메인을 따로따로 분배 받아 만들다보니 각자의 도메인에 맞는 CRUD 를 우선적으로 완성하다보니 이렇게 설계가 된 것 같다.
(JPA 와 데이터베이스 공부를 안한 것이 제일크지만..)

이 때 당시에 프로젝트를 끝나고 느낀점은 완벽한 설계는 아니더라도 어느정도 Table 설계를 진행하여 
공통적으로 묶을수 있는 테이블에 대해서는 추출하여 틀을 잡고 기능개발을 했어야 했다고 생각합니다.



## 문제점

### 1.  중복되는 필드들

종류가 다양한 게시판이여도 공통적으로 게시판이 가져야할 필드들이 존재한다.

- `작성일`,  `수정일`, `작성자`,  `수정자`, `제목내용`

이러한 필드들은 고정적으로 사용된다. 

하지만 위 첨부 사진을 살펴보면 같은 역할을 하는 필드에도 불구하고 제 각각의 이름을 가지고 있다.



### 2.  게시물에 대해서 공통 쿼리를 작성하기가 매우어려움

만약 회원이 작성한 게시글을 보고싶다고 가정해보자.

구현 클래스마다 테이블을 가지고 있기때문에 내가 작성한 글을 모두 찾기위해서는

결국 (중고나라, 도서리뷰, 구인구직, 강의) 테이블에 한번씩 쿼리를 날려서 작성자를 비교하여 찾아야한다.

지금은 쿼리가 4번 발생하지만 나중에 새로운 타입의 게시판이 생긴다면 쿼리가 한개씩 더 추가됩니다.



### 3. 게시판에 공통 기능을 추가할때 할때의 불편함

게시판에서 공통적으로 사용할 [댓글 기능](https://k3068.tistory.com/80?category=873366)(그때의 생각을 정리했던 내용이다.) 을 만든다고 생각해보자

테이블 마다 ID(PK) 를 각자 가진다. 따라서  ID 만으로는 내가 어느 게시판에 댓글을 추가할 것인지 알 수 없다. 

따라서 게시판 타입을 추가로 받아서 비지니스 로직에서 타입별로 분기하여 확인을 진행해야한다.

해당 내용은 앞서 달아놓은 링크를 들어간다면 자세히 설명하고 있다.



## 어떠한 방식으로 설계를 다시할 것인가?

지금은 구현 클래스당 테이블을 가지고 있는 방식에서 <u>**조인 전략**</u>으로 변경해볼 것이다.

![image-20210623183007563](https://tva1.sinaimg.cn/large/008i3skNgy1grsbxgc57ej30jv0aqdgo.jpg)

즉 다음과 같은 구조를 가지고자 한다. (프로젝트 코드를 가지고 하기에는 너무 방대해서 간단한 예제코드로 진행하겠습니다.)

중복되는 필드들을 모아 상위 테이블로 만들고 게시판의 종류에 따라 필요한 속성을 테이블로 만들어서 관리하는 방식으로 관리하고자한다.



![image-20210623184304664](https://tva1.sinaimg.cn/large/008i3skNgy1grscaxad1ij30rb01k74b.jpg)

해당 방식은 데이터를 INSERT 할때마다 2개의 쿼리가 발생한다.

![image-20210623185537978](https://tva1.sinaimg.cn/large/008i3skNgy1grscnz2qi0j30cz0agaas.jpg)

또한 구체 타입을 가져오기위해서 JOIN 을 해서 가져와야한다. 

하지만 앞서 발생하는 문제점에대해서 간단하게 해결할 수 있음으로 앞서 말한 단점들은 그렇게 큰 단점이라고 생각하지 않는다.



따라서 코드는 다음과 같다.

**Board**

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String description;

    private String createBy;

    @CreationTimestamp
    private LocalDate createAt;

}
```

여기서 중요 애노테이션은 `@Inheritance` , `@DiscriminatorColumn` 입니다.



**StudyBoard**

```java
@Entity
public class StudyBoard extends Board{
    
    private String studyName;

    private String place;

    private int recruiter;

    private LocalDateTime recruitmentDeadline;
}
```

그 외 테이블은 [GitHub](https://github.com/KJJ924/spring-data-jpa/tree/master/src/main/java/study/jpa/jpa/board) 을 참고해주세요



## 앞서 살펴본 언급한 문제점이 해결되는가?

### 1.  중복되는 필드들

해당 문제는 상위 테이블인 Board 에 공통적으로 존재하는 필드들을 생성해놨음으로 간단하게 해결된다.



### 2.  게시물에 대해서 공통 쿼리를 작성하기가 매우어려움

`select  b from Board b where b.createBy = :name`

변경된 구조에서는 회원이 작성한 게시글을 찾을때 상위 테이블에만 질의하여 원하는 데이터를 가져올 수 있다.

(기존 쿼리 4번 발생 - > 1번 발생)



### 3. 게시판에 공통 기능을 추가할때 할때의 불편함

```java
public Long existBoard(Long boarId, BoardType boardType) {
  if (BoardType.USEDITEMS.equals(boardType)) {
    result = usedItemExist(boarId);
  }

  if (BoardType.RECRUIT.equals(boardType)) {
    result = recruitExist(boarId);
  }
  ....
}
```

댓글 기능을 추가하기위해 기존에는 PK, TYPE 을 이용한 이러한 분기로직이 필요했다면 



```java
public boolean existBoard(Long id) {
  return boardRepository.existBoard(id)
}
```

이제는 Board ID 값만으로도 해당 게시판이 존재하는지 구분할 수 있다.



## 결론

서비스를 만들때 너무 복잡해진다면 테이블 설계가 애초에 잘못되지는 않았는지 먼저 생각해보는 것도 좋을 것 같습니다.

뭐.. 이번글에서 말하고자 하는것은 **데이터베이스 공부와 설계를 잘하자!**  



해당 본문에 오류가 존재하거나 궁금한 내용이 있으시다면 댓글에 남겨주세요! 

