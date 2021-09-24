package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/09/24
 */
public class ThousandSeparator {

    public static void main(String[] args) {
        System.out.println(thousandSeparator(1234567));
    }

    //1.234  --> 1
    //12.345   --> 2
    public static String thousandSeparator(int n) {
        String result = "" + n;

        if (result.length() <= 3) {
            return result;
        }

        int remainder = result.length() % 3;

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = result.toCharArray();
        if (remainder != 0) {
            for (int i = 0; i < chars.length; i++) {
                if (i % 3 == remainder) {
                    stringBuilder.append(".").append(chars[i]);
                } else {
                    stringBuilder.append(chars[i]);
                }
            }
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (i % 3 == 0 && i != 0) {
                    stringBuilder.append(".").append(chars[i]);
                } else {
                    stringBuilder.append(chars[i]);
                }
            }
        }

        return stringBuilder.toString();
    }

}
