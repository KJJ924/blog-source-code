package coding_test;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/29
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int max = d[0];
        for (int i = 1; i < nums.length; i++) {
            d[i] = Math.max(d[i - 1] + nums[i], nums[i]);
            if (max < d[i]) {
                max = d[i];
            }
        }
        return max;
    }

}
