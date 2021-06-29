package coding_test.leetcode;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/29
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(2));
    }

    // 1,2,3,5,
    public int climbStairs(int n) {
        // f(n) = f(n-1) + f(n-2)
        if (n == 1 || n == 2) {
            return n;
        }
        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 2;
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n - 1];
    }
}
