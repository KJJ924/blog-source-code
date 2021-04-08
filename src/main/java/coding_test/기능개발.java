package coding_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> completionUtil = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int remainingWork = 100 - progress;
            int day = remainingWork / speeds[i];
            if(remainingWork%speeds[i] !=0){
                day +=1;
            }
            completionUtil.add(day);
        }
        Queue<Integer> queue = new LinkedList<>(completionUtil);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int utilCount = 1;
            Integer poll = queue.poll();
            if(queue.peek() ==null){
                result.add(utilCount);
                break;
            }
            if(poll>= queue.peek()){
                while ( queue.peek()!=null && poll>= queue.peek()){
                    utilCount++;
                    queue.poll();
                }
            }
            result.add(utilCount);
        }
        System.out.println(result);
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        기능개발 run = new 기능개발();
        run.solution(new int[]{99,99,99}, new int[]{1, 1, 1});
    }
}
