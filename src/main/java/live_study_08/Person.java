package live_study_08;

public abstract class Person {

    public final int FINGER_COUNT = 10; // 상수도 가질수 있음

    public int age;  //변수를 가질수 있음

    public abstract void language(); //추상 메서드

    public void eat(){
        System.out.println("나는 음식을 입으로 먹는다.");
    }

    public void walk(){
        System.out.println("나는 두 다리로 걷는다.");
    }
}
