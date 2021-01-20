package live_study_10.synchronizedEx;

public class SyncCount {

    int sum = 0;
    synchronized void add(){
        int n = sum;
        n +=10;
        sum =n;
        System.out.println(Thread.currentThread().getName()+":"+sum);
    }
    int getSum(){
        return sum;
    }
}
