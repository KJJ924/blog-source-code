package coding_test;

import java.util.ArrayList;
import java.util.List;

public class 카카오프렌즈컬러링북 {

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        List<Integer> tempSize = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int cur = picture[i][j];
                if (cur == 0 || visited[i][j]) {
                    continue;
                }
                BFS(picture, visited, i, j, cur, tempSize);
                numberOfArea++;
                if(maxSizeOfOneArea < tempSize.size()){
                    maxSizeOfOneArea = tempSize.size();
                }
                tempSize = new ArrayList<>();
            }
        }
        return new int[]{numberOfArea,maxSizeOfOneArea};
    }

    private static void BFS(int[][] picture, boolean[][] visited, int i, int j, int cur , List<Integer> tempSize) {
        visited[i][j] = true;
        tempSize.add(1);

        //오른쪽
        if (j + 1 < picture[0].length && picture[i][j + 1] == cur && !visited[i][j + 1]) {
            BFS(picture, visited, i, j + 1, cur , tempSize);
        }
        //왼쪽
        if (j - 1 >= 0 && picture[i][j - 1] == cur && !visited[i][j - 1]) {
            BFS(picture, visited, i, j - 1, cur, tempSize);
        }
        //위
        if (i - 1 >= 0 && picture[i - 1][j] == cur && !visited[i - 1][j]) {
            BFS(picture, visited, i - 1, j, cur, tempSize);
        }
        //아래
        if (i + 1 < picture.length && picture[i + 1][j] == cur && !visited[i + 1][j]) {
            BFS(picture, visited, i + 1, j, cur, tempSize);
        }
    }


    public static void main(String[] args) {
        solution(6, 4,
            new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}});
    }

}
