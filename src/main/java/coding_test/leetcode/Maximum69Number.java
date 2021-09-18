package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/09/18
 */
public class Maximum69Number {

    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        maximum69Number.maximum69Number(9669);
    }

    public int maximum69Number(int num) {
        String snum = String.valueOf(num);
        String result = snum.replaceFirst("6", "9");
        return Integer.parseInt(result);
    }

}
