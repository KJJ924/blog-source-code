package coding_test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 튜플 {
    public static int[] solution(String s) {
        String target = s.replace("{", "").replace("}","");
        StringTokenizer tokenizer = new StringTokenizer(target,",");
        Map<String, Integer> targetCount = new HashMap<>();
        while (tokenizer.hasMoreTokens()){
            targetCount.merge(tokenizer.nextToken(),1, Integer::sum);
        }

        List<Entry<String, Integer>> collect = targetCount.entrySet().stream()
            .sorted(Entry.comparingByValue(Comparator.reverseOrder())).collect(
                Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (Entry<String, Integer> stringIntegerEntry : collect) {
            result.add(Integer.valueOf(stringIntegerEntry.getKey()));
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] solution = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");

    }

}
