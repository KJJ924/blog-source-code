# Java GC 에 대해 알아보자.

## GC 튜닝의 목적과 대상

GC 가 실행되면 애플리케이션은 GC를 실행시키는 쓰레드를 제외하고 일시적으로 작업을 멈춘다.

따라서 어떤 GC 알고리즘을 사용하더라도 일시적으로 작업이 중지되는 것은 피해갈수 없다.

따라서 GC 를 튜닝한다는것은 stop-the-world 시간을 얼마나 줄이는 것을 말하는 것이다.

GC 의 대상은 힙 내의 객체중에서 unreachable 한 객체를 찾아 정리한다.

그렇다면 unreachable 대상은 어떻게 찾아낼까?

![javareference1](https://d2.naver.com/content/images/2015/06/helloworld-329631-1.png)

Java GC 는 대상을 찾기위해서 **root set**(항상 유효한 참조) 으로부터 연결이 끊어져 있는 객체를 unreachable 으로 판별한다.

### root set

- Java 스택, 즉 Java 메서드 실행 시에 사용하는 지역 변수와 파라미터들에 의한 참조
- 네이티브 스택, 즉 JNI(Java Native Interface)에 의해 생성된 객체에 대한 참조
- 메서드 영역의 정적 변수에 의한 참조

## 자바의 GC 설계의 전제 조건(weak generational hypothesis)

1. 대부분의 객체는 금방 접근 불가능한 상태(unreachable)가된다
2. 오래된 객체에서 젊은 객체로의 참조는 아주 적게 존재한다

이러한 가설을 위해 **Young** 영역과 **Old** 영역으로 2개의 물리적 공간을 나누었다.

- Yong Generation - 새롭게 생성된 객체는 대부분 여기에 위치한다.(이 영역에서 객체가 사라질때 Minor GC 가 발생한다.)
- Old Generation - 접근 불가능 상태로 되지 않아 Young 영역에서 살아남은 객체가 여기로 복사된다.
    - 크기가 큰 만큼 Young 영역보다 GC는 적게 발생한다. (이 영역에서 객체가 사라질 때 Major GC(혹은 Full GC)가 발생한다.)

## Yong Generation

![GC](https://smjeon.dev/assets/img/gc/gc.gif)

Yong Generation 에서도 Eden , Survivor1 , Survivor2 영역으로 나누게 되는데

1. 새로 생긴 객체는 Eden 영역에 생기며

2. Eden 영역이 다차게되면 Minor GC 가 발생하여 Survivor1 영역으로 객체들을 옮기게된다.
3. 1,2 번과정을 반복하여 Survivor1 영역이 다차게된다면 그 중 살아남은 객체들을 Survivor2 영역으로 옮기게된다.
4. 3번과정에서 Survivor1 영역은 완전히 빈공간이 되며 만약 Survivor1,Survivor2 영역중 한 곳은 반드시 빈 공간이여야한다.
   (만약 두 영역이 모두 채워져있다면 GC에 문제가 발생한 것이다.)
5. 앞선 과정을 통해 계속 Survivor1 , Survivor2 이동하면서 객체의 Age 값을 증가시키게된다.
6. 객체 Age 가 특정 값이 넘어간다면 해당 객체는 Old Generation 으로 이동하게된다.

## 참고자료

- https://d2.naver.com/helloworld/329631
- https://d2.naver.com/helloworld/1329