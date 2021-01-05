package live_study_06;

public class Foo {

    public static void main(String[] args) {
        C c = new C();
        C c1 = new C();

        if(c.equals(c1)){
            System.out.println("같니?");
        }else {
            System.out.println("다르니?");
        }
    }
}
