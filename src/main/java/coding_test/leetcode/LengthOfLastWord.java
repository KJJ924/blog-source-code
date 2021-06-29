package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/29
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        lengthOfLastWord.lengthOfLastWord(" ");
    }

    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");

        if (s1.length == 0) {
            return 0;
        }
        String s2 = s1[s1.length - 1];
        return s2.length();
    }

}
