package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/29
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(new int[]{9});
    }

    public int[] plusOne(int[] digits) {
        boolean flag = true;
        int pointer = digits.length - 1;
        while (flag) {
            if (digits[pointer] == 9) {
                digits[pointer] = 0;
                if (pointer == 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    System.arraycopy(digits, 0, result, 1, digits.length);
                    return result;
                }

                pointer -= 1;
            } else {
                digits[pointer] = digits[pointer] + 1;
                flag = false;
            }
        }
        return digits;
    }
}
