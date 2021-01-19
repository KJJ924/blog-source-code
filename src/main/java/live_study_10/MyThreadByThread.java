package live_study_10;

public class MyThreadByThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <500; i++) {
            System.out.print(1);
        }
    }
}
