package coding_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class 두개뽑아서더하기 {
    public static List<Integer> solution(int[] numbers) {
        Queue<Integer> queue = new LinkedList<>();
        for (int number : numbers) {
            queue.add(number);
        }

        Set<Integer> result = new HashSet<>();

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            for (Integer integer : queue) {
                result.add(integer+poll);
            }
        }
        List<Integer> answer = new ArrayList<>(result);
        answer.sort(null);
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{2,1,3,4,1});

    }
}
