package live_study_10.synchronizedEx;

public class MainSolution {
    public static void main(String[] args) {

        SyncCount count = new SyncCount();

        SyncExThread jaeJoon = new SyncExThread("JaeJoon", count);
        SyncExThread kim = new SyncExThread("KIM", count);

        jaeJoon.start();
        kim.start();

    }
}


