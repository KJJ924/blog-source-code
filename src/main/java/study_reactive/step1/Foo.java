package study_reactive.step1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("deprecation")
public class Foo {

    static public class IntObservable extends Observable implements Runnable {

        @Override
        public void run() {
            Iterable<Integer> iterable = Arrays.asList(1, 2, 3, 4);

            for (Integer i : iterable) {
                setChanged();
                notifyObservers(i);
            }

        }
    }

    // for - each 와  Observable 은 서로 반대의 관계이다.
    // for - each 같은 경우 -> 직접 데이터를 next() 통해 pull 해온다.
    // 하지만 observable 같은 경우 Observer 에게 데이터를 push 한다.
    // 즉 Object i = iterable.next() 리턴값이 있지만 pull()
    // notifyObservers(Object Object) 같은 경우 리턴값이 없고 파라미터로 데이터를 넘겨준다. push()
    public static void main(String[] args) {
        Iterable<Integer> iterable = () -> new Iterator<>() {
            final int MAX = 10;
            int start = 0;

            @Override
            public boolean hasNext() {
                return start < MAX;
            }

            @Override
            public Integer next() {
                return start++;
            }
        };

        // for - each
        for (Integer integer : iterable) {
            System.out.println(Thread.currentThread().getName() + ": " + integer);
        }

        //Observable
        Observer observer = (o, arg) -> System.out.println(Thread.currentThread().getName() + ":" + arg);
        IntObservable observable = new IntObservable();
        observable.addObserver(observer);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(observable);
        System.out.println("EXIT");

        executorService.shutdown();

    }


}
