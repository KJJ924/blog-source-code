package dynamicProxyPattern;

public class RealSubject implements  Subject {
    @Override
    public void hello() {
        System.out.println("안녕하세요");
    }

    @Override
    public void bye() {
        System.out.println("다음에 만나요");
    }
}
