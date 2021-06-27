package coding_test.leetcode;

import java.util.Arrays;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/27
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        implementStrStr.strStr("hello","ll");
    }
}
