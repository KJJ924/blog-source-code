package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/26
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        String target = String.valueOf(x);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        stringBuilder.reverse();
        String intToString = stringBuilder.toString();

        return target.equals(intToString);
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        palindromeNumber.isPalindrome(121); // expect : true
        palindromeNumber.isPalindrome(123); // expect : false
        palindromeNumber.isPalindrome(-123); // expect : false
    }

}
