package coding_test;

import java.util.ArrayList;
import java.util.List;

public class 비밀지도{
    public static List<String> solution(int n, int[] arr1, int[] arr2) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            String format = String
                .format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String format2 = String
                .format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = format.toCharArray();
            char[] chars1 = format2.toCharArray();
            for (int j = 0; j < chars1.length; j++) {
                char c = chars1[j];
                char aChar = chars[j];
                int i1 = Integer.parseInt(String.valueOf(c)) | Integer.parseInt(String.valueOf(aChar));
                if(i1 == 1){
                    stringBuilder.append("#");
                }else {
                    stringBuilder.append(" ");
                }
            }
            answer.add(stringBuilder.toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }

}
