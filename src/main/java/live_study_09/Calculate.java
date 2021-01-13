package live_study_09;

public class Calculate {

    static int sum(int x, int y) throws ThousandOverException {

        if(x > 1000 || y>1000) throw  new ThousandOverException();

        return x+y;
    }

}
