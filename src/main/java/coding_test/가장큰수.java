package coding_test;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> stringNumberList = new ArrayList<>();
        for (int number : numbers) {
            stringNumberList.add(String.valueOf(number));
        }
        stringNumberList.sort((o1, o2) ->String.CASE_INSENSITIVE_ORDER.compare(o2+o1,o1+o2));

        for (int i = 0; i < stringNumberList.size(); i++) {
            String s = stringNumberList.get(i);
            if(i==0 && s.equals("0")){
                return "0";
            }
            answer.append(s);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String solution = 가장큰수.solution(new int[]{6, 10, 2});//expect : "6210";
        System.out.println(solution);
    }
}
