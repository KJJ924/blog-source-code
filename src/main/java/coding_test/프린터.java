package coding_test;
import java.util.Collections;
import java.util.PriorityQueue;


public class 프린터 {
    public int solution(int[] priorities, int location) {
        int result = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            queue.add(priority);
        }
        while (!queue.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if(priorities[i] == queue.peek()){
                    if(location == i){
                        return result;
                    }
                    queue.poll();
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        프린터 subject = new 프린터();
        int solution = subject.solution(new int[]{2,3,3,2}, 2);
        System.out.println(solution);
    }

}
