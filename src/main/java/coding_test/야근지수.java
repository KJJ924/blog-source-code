package coding_test;

import java.util.*;

public class 야근지수 {
    public static long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int work : works) {
            queue.add(work);
        }
        for (int i = 0; i < n; i++) {
            Integer poll = queue.poll();
            if(poll<=0) break;
            queue.add(poll-1);
        }

        for (Integer integer : queue) {
            double pow = Math.pow(integer, 2);
            answer +=pow;
        }
        return answer;
    }

    public static void main(String[] args) {
        long solution = 야근지수.solution(99, new int[]{2,15,22,55,55});
        System.out.println(solution);
    }
}
