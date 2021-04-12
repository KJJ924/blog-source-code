package coding_test;

import java.util.Stack;

public class 크레인인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int item = board[i][move - 1];
                if (item != 0) {
                    board[i][move - 1] = 0;
                    if (!basket.isEmpty() && basket.peek() == item) {
                        basket.pop();
                        answer++;
                    } else {
                        basket.push(item);
                    }
                    System.out.println("i1 = " + item);
                    break;
                }
            }
        }
        return answer * 2;
    }

}
