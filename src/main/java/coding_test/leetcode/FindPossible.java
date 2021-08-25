package coding_test.leetcode;

import java.util.stream.IntStream;

/**
 * @author dkansk924@naver.com
 * @since 2021/08/24
 */
public class FindPossible {

    public static void main(String[] args) {
        FindPossible FindPossible = new FindPossible();
        int[] e = {2, 1, 1, 0, 1};
        System.out.println(FindPossible.solution(3, 2, e));
    }

    public String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        if (U + L != IntStream.of(C).sum()) {
            return "IMPOSSIBLE";
        }

        int arrayLength = C.length;

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < arrayLength; i++) {

            if (C[i] == 2) {
                sb.append(1);
                sb2.append(1);
                U -= 1;
                L -= 1;
                continue;
            }

            if (U != 0 && C[i] != 0) {
                sb.append(1);
                sb2.append(0);
                U -= 1;
            } else if (L != 0 && C[i] != 0) {
                sb.append(0);
                sb2.append(1);
                L -= 1;
            } else {
                sb.append(0);
                sb2.append(0);
            }
        }
        return sb.toString() + "," + sb2.toString();
    }
}
