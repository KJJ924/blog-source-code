package coding_test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dkansk924@naver.com
 * @since 2021/09/24
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        int[] a = {8, 1, 2, 2, 3};
        smallerNumbersThanCurrent(a);
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                List<Integer> integers = indexMap.get(nums[i]);
                integers.add(i);
            } else {
                List<Integer> integers = new ArrayList<>(List.of(i));
                indexMap.put(nums[i], integers);
            }
        }
        Arrays.sort(nums);
        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            int j = i;

            if (i < nums.length - 1) {
                while (nums[i] == nums[i + 1]) {
                    i++;
                    if (i == nums.length - 1) {
                        break;
                    }
                }
            }

            for (Integer integer : indexMap.get(nums[j])) {
                result[integer] = j;
            }
        }
        return result;
    }

}
