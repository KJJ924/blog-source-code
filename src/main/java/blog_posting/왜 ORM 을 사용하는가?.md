# JPA 를 선택한 이유

## JPA(ORM) 기술은 왜 사용하는가?

1. SQL 중심적인 개발을 벗어나게 해준다. -> 즉 기존 SQL 중심의 프로젝트는 **객체 중심의 코딩이 불가능** 했다.

**예제코드**

   ```java
   public static void main(String[]args)throws Exception{
    Class.forName("jdbc");
    Connection con=DriverManager.getConnection("DBURL","username","password");

    Statement stmt=con.createStatement();

    String query="query" // name,age,address
    ResultSet rs=stmt.executeQuery(query);

    List<Person> persons=new ArrayList<>();
    while(rs.next()){
    String name=rs.getString("name");
    int age=rs.getInt("age");
    String address=rs.getInt("address");
    persons.add(new Person(name,age,address));
    }
    }
   ```

해당 예제코드는 말그대로 DB에 접근하여 자료를 읽어 가져오는 역할만 한다.

만약 해당 프로젝트에서 name, age , address -> Person 이라는 객체로 사용하기위해서는 일일이 생성해줘야한다.

여기까지는 객체지향스럽게 코딩이 가능하다고 생각할 수 있다,

하지만 예제코드는 말 그대로 예제코드일 뿐 현실은 그렇지않다.

결국 프로젝트 규모가 커질수록 객체중심 코딩은 불가능하며 데이터중심의 코드만 짜게된다.

2. 객체와 관계형 데이터베이스의 패러다임 불일치를 해소해준다,

    - 상속

    - 연관관계 - **객체**는 참조를 사용 , **테이블**은 외래키를 사용한다

    - 데이터 타입

    - 데이터 식별 방법


3. 객체 그래프 탐색 Member -> Order -> OrderItem -> Item

    - 처음 실행하는 SQL 에 따라 탐색 가능범위가 결정되버림 Member -> Order -> Item 인 경우에서 Member -> Order 까지만 로딩이 되었다
      가정하고 나는 사용했지만 다른사람이 보았을때 Item 을 접근할수 있기때문에 만약 접근한다면 NPE 가 발생한다.

    - 하지만 JPA 같은 경우 지연로딩, 즉시로딩을 설정할수 있기때문에 앞서 살펴본 오류를 방지할 수 있다.

      (단 N+1 문제든 예상치 못한 쿼리가 발생할 수 있다. 따라서 잘 알고 쓰자!)

## JPA 와 hibernate 의 관계

JPA 를 사용하다보면 hibernate 이야기는 항상 나오게된다.

그리고 깊게 공부하지 않는다면 **hibernate 와 JPA 는 똑같다고 생각할 수 있다**.

위의 말은 100% 틀린말은 아니지만 또한 100% 맞는 말도 아니다.

### JPA는 단지 자바 진영의 표준 ORM 기술이다.

- 즉 ORM 의 기술을 사용하기위한 표준 인터페이스를 제공한다는 뜻이다.

  ![image-20210814215359063](https://tva1.sinaimg.cn/large/008i3skNgy1gtgm1mkdu0j61by0lb77s02.jpg)


- <u>인터페이스를 제공해준다는 뜻은</u>  **JPA 를 사용한다면 하위 구현체로 hibernate 가 아닌 다른 하위 구현체로 변경할 수 있다는 뜻이다.**
- hibernate 이외에도 JPA 지원하는 벤더들도 많이 존재한다.
  ![image-20210814215756512](https://tva1.sinaimg.cn/large/008i3skNgy1gtgm66avitj607e07ojrg02.jpg)

결과적으로 하위 구현체로 hibernate 가 많이 사용될 뿐이지 JPA == hibernate 인건 아니다.

추 후 hibernate 보다 뛰어난 ORM 프로젝트가 나온다면 미래에는 얼마든지 교체될 수 있다.

하지만 우리가 진행하고 있는 프로젝트의 코드를 변경하지 않아도 새로운 구현체가 (ORM 프로젝트) JPA 인터페이스를 완벽하게 지원한다면

인터페이스의 하위 구현체만 변경하여 더 좋은 성능의 ORM 프로젝트를 사용할 수 있다.

## 그렇다면 JPA는 단점이 없는가?

(제 생각이 어느정도 들어간 문단입니다.)

### 편안함에서 오는 복잡함(무슨소리야?🤔 )

- 제가 말하고자하는것은 <u>예상하지 못한 Query 구문, 발생 횟수</u> 뿐이 아닌

- <u>편리함을 추구하기위해 **과도하게 연관관계를 맺는 행위**를 말하고자합니다.</u>

**객체그래프 탐색**은 매우 매력적이고 개발을 함에 있어 매우 편리하여 양방향 연관관계를 맺어 사용하는 경우가 있습니다.

사실 도메인 로직상 과도한 연관관계가 필요한 경우는 제가 아직까지 만나보지 못한걸수도 있지만 대부분 단방향이거나 연관관계를 굳이 맺고 있지않아도 처리가 가능합니다.

즉 CRUD 에서 CUD 로직은 과도한 연관관계가 대부분 필요없다고 생각합니다.

![image-20210814234745935](https://tva1.sinaimg.cn/large/008i3skNgy1gtgpc66q78j60hs05tjrw02.jpg)

위의 예제는 제가 프로젝트를하면서 연관관계에대해서 다시 생각해본 내용입니다.(해당 이유가 정답이 아닐수도 있지만)

Entity 간의 연관관계가 **꼭 필요한지 한번쯤은 생각해보는것도 좋을듯 합니다.**

또한 프로젝트의 연관관계가 너무 복잡하시다면

- CRUD 의 **Read**(select) 를 편하게 하기위해서 맺는 경우가 있는지 한번 확인해보시면 좋을것 같습니다.

### 높은 학습비용

- 아직까지도 JPA 를 사용하다보면 N+1 문제
- 영속성 컨텍스트 범위 관리를하지 못하여 update 가 되지않거나
- 예상하지 못한 쿼리가 발생한다거나

JPA 를 주의하면서 쓴다고해도 100% 해당문제를 다시 안만난다는 보장은 없습니다.

### 성능

- 앞서 말한것처럼 간단한 Select Query 는 JPA 로 사용해도 괜찮지만
- 복잡한 통계성 쿼리는 JPA의 JPQL을 이용하기 보다는 Native query를 사용하거나 Mybatis 를 이용하는것이 좋다.



