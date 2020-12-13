package dynamicProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Subject subject= (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class},
                Solution.invocationHandler(new RealSubject()));
        subject.hello();
        subject.bye();
    }
    private static InvocationHandler invocationHandler(Object o){
        return (proxy, method, args) -> {
            if(method.getName().equals("hello")) {
                long l = System.currentTimeMillis();
                Thread.sleep(1000);
                Object invoke = method.invoke(o, args);
                System.out.println(System.currentTimeMillis() - l);
                return invoke;
            }
            return method.invoke(o,args);
        };
    }
}