package live_study_10;

public class MainSolution {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThreadByThread thread =new MyThreadByThread();
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
