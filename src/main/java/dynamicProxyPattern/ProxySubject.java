package dynamicProxyPattern;

public class ProxySubject implements Subject {

    private final Subject subject;

    public ProxySubject(){
        this.subject = new RealSubject();
    }

    @Override
    public void hello() {
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
            subject.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-l);
    }

    @Override
    public void bye() {
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
            subject.bye();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-l);
    }
}
