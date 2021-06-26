package coding_test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/26
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        List<String> list = new ArrayList<>(List.of(strs));
        String target = list.get(0);

        String result = "";
        for (int i = 1; i < target.length()+1; i++) {
            String substring = target.substring(0, i);
            if(list.stream().filter(s-> s.startsWith(substring)).count() == list.size()){
                result = substring;
            }else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"abc","a","a"})); //expect:a
    }
}
