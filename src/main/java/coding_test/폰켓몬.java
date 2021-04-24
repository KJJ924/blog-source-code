package coding_test;


import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

    public static int solution(int[] nums) {
        int selectCount =  nums.length/ 2;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(set.size(), selectCount);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3})); // expect 2
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4})); // expect 3
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2})); // expect 2
    }

}
