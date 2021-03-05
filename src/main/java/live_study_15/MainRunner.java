package live_study_15;

import live_study_04.option1.Member;

public class MainRunner {
    private String hello  = "hello";
    public static void main(String[] args) {
        Foo foo = hi -> {
            String hello = "hello";
            System.out.println(hi);
        };
    }
}
