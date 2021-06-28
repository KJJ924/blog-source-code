package coding_test.leetcode;


/**
 * @author dkansk924@naver.com
 * @since 2021/06/28
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int s = searchInsertPosition
            .searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println("s = " + s);
    }

    public int searchInsert(int[] nums, int target) {
        int length = nums.length - 1;
        int base = 0;

        while (base <= length) {
            int midIndex = (base + length) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (nums[midIndex] < target) {
                base = midIndex + 1;
            } else {
                length = midIndex - 1;
            }
        }
        return base;
    }

}
