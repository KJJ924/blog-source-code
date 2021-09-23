package coding_test.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dkansk924@naver.com
 * @since 2021/09/23
 */
public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : matrix) {
            List<Integer> collect = IntStream.of(ints).boxed().collect(Collectors.toList());
            list.addAll(collect);
        }
        list.sort(Comparator.comparingInt(o -> o));

        return list.get(k - 1);
    }
}
