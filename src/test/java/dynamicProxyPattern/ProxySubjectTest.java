package dynamicProxyPattern;

import org.junit.jupiter.api.Test;

class ProxySubjectTest {

    @Test
    void ProxyPattern(){
        Subject subject = new ProxySubject();
        subject.hello();
        subject.bye();
    }

    @Test
    void RealSubject(){
        Subject subject = new RealSubject();
        subject.hello();
        subject.bye();
    }

}