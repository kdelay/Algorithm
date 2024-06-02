import java.util.*;

class Solution {
    /**
     * @param board 격자
     * @param moves 크레인 작동 위치
     * @return 터트려져 사라진 인형의 개수
     */
    public static int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer>[] stack = new ArrayDeque[board.length];

        //stack 초기화
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new ArrayDeque<>();
        }

        //board 순환
        for (int i = board.length-1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                //인형이 있는 경우만 stack 열에 추가한다.
                if (board[i][j] > 0) {
                    stack[j].push(board[i][j]);
                }
            }
        }

        ArrayDeque<Integer> bucket = new ArrayDeque<>();
        int answer = 0;

        for (int move : moves) {

            if (!stack[move - 1].isEmpty()) {
                int doll = stack[move - 1].pop();

                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }
        return answer;
    }
}