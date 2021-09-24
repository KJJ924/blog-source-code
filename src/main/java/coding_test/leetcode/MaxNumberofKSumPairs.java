package coding_test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dkansk924@naver.com
 * @since 2021/09/24
 */
public class MaxNumberofKSumPairs {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        maxOperations(a, 5);
    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countingNumber = new HashMap<>();

        int counting = 0;
        for (int num : nums) {
            if (countingNumber.containsKey(k - num)) {
                if (countingNumber.get(k - num) == 0) {
                    countingNumber.merge(num, 1, Integer::sum);
                } else {
                    counting += 1;
                    countingNumber.put(k - num, countingNumber.get(k - num) - 1);
                }
            } else {
                countingNumber.merge(num, 1, Integer::sum);
            }
        }
        return counting;
    }

}
