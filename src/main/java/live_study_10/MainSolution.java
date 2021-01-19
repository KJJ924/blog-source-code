package live_study_10;

public class MainSolution {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThreadByThread thread =new MyThreadByThread();
        thread.start();

        Thread thread1 = new Thread(new MyThreadByRunnable());
        thread1.start();
    }
}
