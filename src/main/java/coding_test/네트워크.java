package coding_test;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                dfs(i,computers,visited);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int n, int[][] computers, boolean[] visited) {
        visited[n] = true;
        for (int i = 0; i < computers.length; i++) {
             if(!visited[i] && computers[n][i]==1){
                 dfs(i,computers,visited);
             }
        }
    }

    public static void main(String[] args) {
        네트워크 subject = new 네트워크();
        int solution = subject.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(solution);
    }
}
