package coding_test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수식최대화 {
    public static long solution(String expression) {
        List<String> formula = new ArrayList<>(List.of("+","-","*"));
        List<List<String>> ret = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        BT(formula,ret,temp);

        List<String> expressionToken = new ArrayList<>();
        char[] chars = expression.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if(formula.contains(String.valueOf(aChar))){
                expressionToken.add(stringBuilder.toString());
                expressionToken.add(String.valueOf(aChar));
                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(aChar);
        }
        expressionToken.add(stringBuilder.toString());
        System.out.println("expressionToken = " + expressionToken);

        List<Long> result = new ArrayList<>();

        for (List<String> stringList : ret) {
            List<String> tempToken = new ArrayList<>(List.copyOf(expressionToken));
            for (String s : stringList) {
                while (tempToken.contains(s)){
                    int i = tempToken.indexOf(s);
                    long pre = Long.parseLong(tempToken.get(i - 1));
                    long post = Long.parseLong(tempToken.get(i + 1));
                    String calculation = calculation(pre, post, s);
                    tempToken.remove(i-1);
                    tempToken.remove(i-1);
                    tempToken.remove(i-1);
                    tempToken.add(i-1,calculation);
                }
            }
            result.add(Math.abs(Long.parseLong(tempToken.get(0))));
        }
        return Collections.max(result);
    }

    private static String calculation(long pre , long post , String result){
        switch (result){
            case "+":
                return String.valueOf(pre+post);
            case "-":
                return String.valueOf(pre-post);
            case "*":
                return String.valueOf(pre*post);
        }
        throw new IllegalArgumentException();
    }

    private static void BT(List<String> expressionIncludeFormula,List<List<String>> ret, List<String> temp) {

        if(temp.size() == expressionIncludeFormula.size()){
            ret.add(new ArrayList<>(temp));
            return;
        }
        for (String s : expressionIncludeFormula) {
            if(temp.contains(s))continue;
            temp.add(s);
            BT(expressionIncludeFormula, ret, temp);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args) {
        long solution = solution("100-200*300-500+20");
        System.out.println("solution = " + solution);
    }

}
