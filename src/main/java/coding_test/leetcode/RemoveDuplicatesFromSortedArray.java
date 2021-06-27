package coding_test.leetcode;


import java.util.Stack;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/27
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if(stack.isEmpty()){
                stack.push(num);
            }else {
                if (stack.peek() != num) {
                    stack.push(num);
                }
            }
        }
        int[] ints = stack.stream().mapToInt(Integer::intValue).toArray();
        System.arraycopy(ints, 0, nums, 0, ints.length);
        return stack.size();
    }


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        solution.removeDuplicates(new int[]{1,1,2});

    }
}
