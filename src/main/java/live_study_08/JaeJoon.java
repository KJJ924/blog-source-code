package live_study_08;

public class JaeJoon extends Person implements ButterflyStroke ,Programing{

    public JaeJoon(int age) {

        this.age = age;
    }

    @Override
    public void language() {
        application();
        System.out.println("저는 한국어를 사용합니다");
    }

    @Override
    public void swim() {
        System.out.println("수영을 합니다");
    }


    @Override
    public void butterflyStroke() {
        System.out.println("접영을 합니다");
    }

    @Override
    public void freestyle() {
        System.out.println("자유형 합니다");
    }

    @Override
    public void programing() {
        System.out.println("코딩을 할줄 압니다.");
    }
}
