package live_study_10;

import java.util.Scanner;

public class MainSolution {
    public static void main(String[] args) {
        System.out.println("main 쓰레드 시작");
        MyThreadByThread myThreadByThread =new MyThreadByThread();
        Thread myThreadByRunnable = new Thread(new MyThreadByRunnable());

        myThreadByThread.start();
        myThreadByRunnable.start();
        myThreadByThread.interrupt();

        String s = new Scanner(System.in).next(); // BLOCKED 상태 입력값을 대기하는중..
        System.out.println("입력값은 "+s+"입니다");

        try {
            myThreadByThread.join();   //WAITING  상태  Main 쓰레드가 myThreadByThread 작업이 종료될때까지 기달림
            myThreadByRunnable.join(); //WAITING  상태  Main 쓰레드가 myThreadByRunnable 작업이 종료될때까지 기달림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Main 쓰레드 :한숨 자고 종료하자..");
        try {
            Thread.sleep(10000); //TIMED_WAITING 상태 주어진 1초를 기달렸다가 종료됨
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main 쓰레드 종료");
    }
}
