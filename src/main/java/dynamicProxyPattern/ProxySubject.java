package dynamicProxyPattern;

public class ProxySubject implements Subject {

    private final Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void hello() throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(1000);
        subject.hello();
        System.out.println(System.currentTimeMillis()-l);
    }

    @Override
    public void bye() throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(1000);
        subject.bye();
        System.out.println(System.currentTimeMillis()-l);
    }
}
