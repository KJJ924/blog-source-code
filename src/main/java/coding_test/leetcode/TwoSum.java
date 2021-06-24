package coding_test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/24
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(target-num)){
                return new int[]{map.get(target-num), i};
            }else {
                map.put(num,i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{3,2,4}, 6);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }

    }
}