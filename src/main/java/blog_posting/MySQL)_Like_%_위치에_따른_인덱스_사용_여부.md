# MySql  Like % 위치에 따른 인덱스 사용 여부

## 서론

Table 내 어떠한 칼럼에 index 를 설정하여 Like 문을 통해 검색하는 경우

INDEX 설정을 하였어도 <u>% 위치에 따라 INDEX 가 정상적으로 작동하는 경우가 있지만 반대로 잘못 사용한경우 **Full Scan 이 발생**할 수 있다.</u>

이번글에서는 LIKE 검색에서 % 위치에 따른 INDEX 사용여부를 하나씩 살펴볼것이다.

###  

### Table 구조

간단한 Member Table 이며 더미 데이터수는 1만개로 설정하였다.

```sql
CREATE TABLE `Member`
(
    `id`      int(9) unsigned NOT NULL AUTO_INCREMENT,
    `name`    varchar(100) NOT NULL,
    `address` varchar(255) NOT NULL,
    `age`     int(11)      NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;;

```

INDEX 칼럼

```sql
CREATE INDEX MEMBER_NAME ON Member (name);
```

## 1. 'ABC%' 데이터 시작 형식 을 검사하는경우

`name like 'AB%'` 검색인 경우 AB 로 시작하는 데이터들을 조회하고자 하는것이다.

![image-20210909001521636](https://tva1.sinaimg.cn/large/008i3skNgy1gu9mmdg9stj60nz05vjrv02.jpg)

해당 조회같은경우에는 인덱스가 잘 적용되는것을 확인할 수 있다.

## 2. '%ABC' 끝나는 데이터 형식을 검사하는 경우

`name like '%AB'` 검색인 경우 AB 로 끝나는 데이터들을 조회하고자 하는것이다.

![image-20210909001559073](https://tva1.sinaimg.cn/large/008i3skNgy1gu9mn1fpmcj60kt05maag02.jpg)

해당 조회같은경우에는 인덱스가 적용되지 않는다.

## 3. '%ABC%' 데이터에 포함하는지 검사하는 경우

`name like '%AB%'` 검색인 경우 AB가 포함된 데이터들을 조회하고자 하는것이다.

![image-20210909001456146](https://tva1.sinaimg.cn/large/008i3skNgy1gu9mly3t3hj60kx05vdg702.jpg)

해당 조회같은경우에는 인덱스가 적용되지 않는다.

## 왜? AB% 를 제외한 나머지 방식은 인덱스를 타지않을까?

데이터베이스의 인덱스의 자료구조는 대부분 B-TREE 구조로 이루어져 있다.

(B-TREE 은 노드의 자식노드의 데이터들은 노드 데이터 기준으로 데이터보다 작은 값이 왼쪽부터 오른쪽으로 정렬되어 있다.)

이러한 구조를 가지고있다고 생각하고 `왜? % 위치에 따라 인덱스조건이 타지않는가?` 에 대해 다시 생각해보면

당연히 타지 않을꺼라고 생각했어야 했다. 하지만 생각없이 사용하다보면 놓칠 수 있다고도 생각한다.

## 그럼 어떻게 검색 해야하는가?

MySQL 5.7 버전 이상부터 FullText Search(전문 검색) 방식을 사용하여 앞서 살펴본

'%ABC%'  '%ABC' 검색을 사용했을때 인덱스를 사용하지 못한 부분을

`FullText Search` 을 사용한다면 빠른 검색이 가능하다고 합니다.

해당 본문에서는 FullText Search 대해서 설명하지는 않겠습니다.

추 후 FullText Search 사용방법과 어떻게 동작하는지에 대해 공부해서 포스팅하도록 하겠습니다.

## 참고자료

https://dev.mysql.com/doc/refman/8.0/en/index-btree-hash.html

https://hoing.io/archives/16853

https://stackoverflow.com/questions/2042269/how-to-speed-up-select-like-queries-in-mysql-on-multiple-columns





