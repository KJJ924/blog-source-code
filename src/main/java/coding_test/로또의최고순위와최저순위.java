package coding_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/24
 */
public class 로또의최고순위와최저순위 {

    public static int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> ranking = new HashMap<>(){{
            put(6,1);
            put(5,2);
            put(4,3);
            put(3,4);
            put(2,5);
            put(1,6);
            put(0,6);
        }};

        List<Integer> lottoList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNumber = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        long zeroCount = lottoList.stream().filter(i -> i.equals(0)).count(); // 알아 볼수 없는 숫자 갯수
        long answerCount = lottoList.stream().filter(winNumber::contains).count();  // 맞은 갯수

        Integer topRanks = ranking.get(Long.valueOf(zeroCount+answerCount).intValue());// 최고 등수
        Integer rowRanks = ranking.get(Long.valueOf(answerCount).intValue()); //최저 등수
        return new int[]{topRanks,rowRanks};
    }

    public static void main(String[] args) {
        //todo 최고 순위와 최저 순위를 구해라
        //1. 모두 안보이는 번호(0) 이 모두 맞으면 (최고순위)
        //2. 안 보이는 번호가 모두 틀리면 (최저순위)
        //3. 순서는 상관없이 일치하는 번호가 있다면 맞음
        int[] solution = solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
    }
}
