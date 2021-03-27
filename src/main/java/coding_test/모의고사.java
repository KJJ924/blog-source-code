package coding_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class 모의고사 {

    public int[] solution(int[] answers) {
        List<Integer> one = List.of(1, 2, 3, 4, 5);
        List<Integer> two = List.of(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> three = List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
        List<Integer> count = new ArrayList<>(List.of(0,0,0));
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int oneIndex = i % 5;
            int twoIndex = i % 8;
            int threeIndex = i % 10;
            if(one.get(oneIndex) == answer){
                count.set(0,count.get(0)+1);
            }
            if(two.get(twoIndex) == answer){
                count.set(1,count.get(1)+1);
            }
            if(three.get(threeIndex) == answer){
                count.set(2,count.get(2)+1);
            }
        }
        System.out.println("count = " + count);

        Integer max = Collections.max(count);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            if (count.get(i).equals(max)) {
                result.add(i + 1);
            }
        }
        System.out.println("result2 = " + result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        모의고사 모의고사 = new 모의고사();
        int[] a = {1,3,2,4,2};
        모의고사.solution(a);
    }
}
