package coding_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkansk924@naver.com
 * @since 2021/06/24
 */
public class 행렬테두리회전하기 {

    public static List<Integer> solution(int rows, int columns, int[][] queries) {
        List<List<Integer>> column = new ArrayList<>();
        int target = 1;
        for (int i = 1; i <= columns; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= rows; j++) {
                temp.add(target++);
            }
            column.add(temp);
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int x1 = query[0]-1;
            int x2 = query[2]-1;
            int y1 = query[1]-1;
            int y2 = query[3]-1;
            result.add(rotation(x1,y1,x2,y2,column));
        }
        return result;
    }

    public static int rotation(int x1, int y1, int x2, int y2, List<List<Integer>> column){
        int rx = Math.abs(x1-x2);
        int ry = Math.abs(y1-y2);

        int target = column.get(x1).get(y1);
        int min = target;
        for(int i=0; i<ry; i++){
            int temp =column.get(x1).get(y1+i);
            column.get(x1).set(y1+i,target);
            target =temp;
            if(target <min){
                min =target;
            }
        }

        for(int i=0; i<rx; i++){
            int temp =column.get(x1+i).get(y2);
            column.get(x1+i).set(y2,target);
            target =temp;
            if(target <min){
                min =target;
            }
        }

        for(int i=0; i<ry; i++){
            int temp = column.get(x2).get(y2-i-1);
            column.get(x2).set(y2-i-1,target);
            target= temp;
            if(target <min){
                min =target;
            }
        }

        for(int i=0; i<rx; i++){
            int temp =column.get(x2-i-1).get(y1);
            column.get(x2-i-1).set(y1,target);
            target =temp;
            if(target <min){
                min =target;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        List<Integer> solution = solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        System.out.println("solution = " + solution);

    }
}
