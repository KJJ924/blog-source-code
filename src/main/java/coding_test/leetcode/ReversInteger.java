package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/24
 */
public class ReversInteger {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while (sb.toString().startsWith("0")) {
            sb.delete(0, 1);
        }
        if (sb.substring(sb.length() - 1, sb.length()).equals("-")) {
            sb.insert(0, "-");
            sb.delete(sb.length() - 1, sb.length());
        }
        if (Integer.MAX_VALUE < Long.parseLong(sb.toString()) || Integer.MIN_VALUE > Long
            .parseLong(sb.toString())) {
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        ReversInteger reversInteger = new ReversInteger();
        reversInteger.reverse(1534236469); // expect: 321
        reversInteger.reverse(-321); // expect: -321
        reversInteger.reverse(120); // expect: 21
    }
}
