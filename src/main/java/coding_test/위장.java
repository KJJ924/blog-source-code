package coding_test;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        Map<String,Integer> category = new HashMap<>();

        for (String[] clothe : clothes) {
            category.merge(clothe[1], 1, (a, b) -> category.get(clothe[b]) + b);
        }
        int answer = 1;
        for (String s : category.keySet()) {
           answer *=category.get(s)+1;
        }
        return answer-1;
    }
}
