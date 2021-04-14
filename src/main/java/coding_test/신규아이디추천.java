package coding_test;

import java.util.Stack;
import java.util.regex.Pattern;

public class 신규아이디추천 {
    public static String solution(String new_id) {
        String toLowerNewId = new_id.toLowerCase();
        char[] charAtNew_id = toLowerNewId.toCharArray();
        Pattern compile = Pattern.compile("^[a-z[0-9][-][_][.]]$");
        Stack<String> stack = new Stack<>();
        for (char c : charAtNew_id) {
            String target = String.valueOf(c);
            if(stack.isEmpty() && target.equals("."))continue;
            if(!compile.matcher(target).matches()) continue;
            if(!stack.isEmpty() &&stack.peek().equals(".") && target.equals(".")){
                continue;
            }
            stack.add(target);
        }

        StringBuilder result = new StringBuilder(getResult(stack));

        if(result.length() == 0){
           result = new StringBuilder("a");
        }

        if(result.length()<=2){
            int lastIndex = result.length() - 1;
            int length = result.length();
            char c = result.charAt(lastIndex);
            for (int i = 0; i < 3-length; i++) {
                result.append(c);
            }
        }
        System.out.println("result = " + result);
        return result.toString();
    }

    private static String getResult(Stack<String> stack) {
        StringBuilder stringBuilder  = new StringBuilder();
        for (String s : stack) {
            stringBuilder.append(s);
        }
        String result = removeLastPeriod(stringBuilder.toString());
        if(16<=result.length()){
            result=result.substring(0,15);
        }
        return removeLastPeriod(result);
    }

    private static String removeLastPeriod(String result) {
        while (result.endsWith(".")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }


    public static void main(String[] args) {
        String solution = solution("=.=");
        System.out.println("solution = " + solution); //expect : "bat.y.abcdefghi"
    }
}
