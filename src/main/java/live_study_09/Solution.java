package live_study_09;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws ThousandOverException {

        Calculate.sum(10,20);

        List<Object> objectNumberList  =new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            objectNumberList.add(i);
            objectNumberList.add(String.valueOf(i));
        }
        System.out.println(objectNumberList);

        int result = 0;
        for (Object o : objectNumberList) {
            try {
                int i = (int) o;
                result+=i;
            }catch (ClassCastException e){
                String s  = (String)o;
                int i = Integer.parseInt(s);
                result+=i;
            }
        }
        System.out.println(result);
    }
}
