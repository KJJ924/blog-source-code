package coding_test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dkansk924@naver.com
 * @since 2021/09/23
 */
public class RedistributeCharactersToMakeAllStringsEqual {

    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        makeEqual(words); // true;
    }

    public static boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                map.merge(aChar, 1, Integer::sum);
            }
        }

        for (Integer value : map.values()) {
            if (value % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
