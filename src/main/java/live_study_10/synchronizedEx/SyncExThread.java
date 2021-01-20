package live_study_10.synchronizedEx;

public class SyncExThread extends Thread {
    SyncCount syncCount;

    public SyncExThread(String name, SyncCount syncCount) {
        super(name);
        this.syncCount = syncCount;
    }

    @Override
    public void run() {
        int i= 0;
        while (i<100){
            syncCount.add();
            i++;
        }
    }
}
