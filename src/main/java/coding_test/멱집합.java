package coding_test;

import java.util.ArrayList;
import java.util.List;

public class 멱집합 {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(5, 4, 2));
        int[] flagList = new int[intList.size()];
        List<Integer> result = new ArrayList<>();
        List<Integer> result_ = powerSet(intList, flagList, 0, result);
        System.out.println(result_);
    }

    private static List<Integer> powerSet(List<Integer> intList, int[] flagList, int n,
        List<Integer> result) {
        if (n == flagList.length) {
            result.add(print(intList, flagList));
            return result;
        }

        flagList[n] = 1;
        powerSet(intList, flagList, n + 1, result);

        flagList[n] = 0;
        powerSet(intList, flagList, n + 1, result);

        return result;
    }

    private static int print(List<Integer> intList, int[] flagList) {
        int sum = 0;
        for (int i = 0; i < flagList.length; i++) {
            if (flagList[i] == 1) {
                sum += intList.get(i);
            }
        }
        return sum;
    }
}
