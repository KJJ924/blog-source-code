package coding_test;

import java.util.ArrayList;
import java.util.List;


public class n개중에서m개를뽑는조합 {

    public static List<List<Integer>> solution(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            backTracking(ret, temp, nums, visited, i);
        }
        return ret;
    }

    private static void backTracking(List<List<Integer>> ret, List<Integer> temp, int[] nums,
        boolean[] visited, int index) {
        visited[index] = true;

        if (temp.size() == 4) {
            ret.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(nums[i]);
            backTracking(ret, temp, nums, visited, i);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> solution = solution(new int[]{2, 1, 3, 4});
        System.out.println("solution  ,Size = " + solution + "," + solution.size());

    }

}
