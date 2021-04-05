package coding_test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 주식가격 {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }
        int size = queue.size();
        List<Integer>  result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int second = 0;
            Integer peek = queue.poll();
            if(peek ==null){
                result.add(0);
            }
            for (Integer integer : queue) {
                second++;
                if (peek>integer) break;
            }
            result.add(second);
        }
        return result.stream().mapToInt(i ->i).toArray();
    }

    public static void main(String[] args) {
        주식가격 a = new 주식가격();
        int[] prices = {1,2,3,2,3};
        a.solution(prices);

    }
}
