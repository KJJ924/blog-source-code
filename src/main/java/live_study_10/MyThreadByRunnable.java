package live_study_10;

public class MyThreadByRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.print(0);
        }
    }
}
