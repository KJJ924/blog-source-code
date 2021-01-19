package live_study_10;

public class MyThreadByThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <500; i++) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i+"번쨰="+1);
        }
    }
}
