package coding_test.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/26
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
            }
        };
        String[] split = s.split("");
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s1 : split) {
            Integer target = romanMap.get(s1);
            if (stack.isEmpty()) {
                stack.add(target);
                continue;
            }
            if (stack.peek() > target) {
                result += stack.pop();
                stack.add(target);
                continue;
            }
            if (stack.peek().equals(target)){
                result += target+stack.pop();
                continue;
            }
            result += target - stack.pop();
        }
        if(!stack.isEmpty()){
            result+= stack.pop();
        }
        System.out.println("stack = " + result);
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        romanToInteger.romanToInt("III"); //expect = 3
        romanToInteger.romanToInt("IV"); //expect = 4
        romanToInteger.romanToInt("IX"); //expect = 9
        romanToInteger.romanToInt("LVIII"); //expect = 58
        romanToInteger.romanToInt("MCMXCIV"); //expect = 1994
    }
}
