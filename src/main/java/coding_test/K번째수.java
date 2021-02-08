package coding_test;

import java.util.ArrayList;
import java.util.List;

public class K번째수 {
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            List<Integer> result = new ArrayList<>();
            for (int[] command : commands) {
                List<Integer> rangeList = new ArrayList<>();
                for(int i = command[0]-1; i<command[1]; i++){
                    rangeList.add(array[i]);
                }
                rangeList.sort(Integer::compareTo);
                result.add(rangeList.get(command[2]-1));
            }
            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {

                answer[i] = result.get(i);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(ints);
    }
}
