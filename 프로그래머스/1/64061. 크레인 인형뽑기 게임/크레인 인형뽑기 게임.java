import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        //뽑기 횟수만큼 진행
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int tmp = board[i][move - 1];
                //인형이 있는 경우만 뽑기 진행
                if (tmp > 0) {
                    //바구니에 넣기
                   stack.push(tmp);
                    //인형 뽑기
                    board[i][move - 1] = 0;
                    break;
                }
            }
            //바구니에 연속해서 쌓인 인형이 있을 경우 제거
            if (stack.size() > 1) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                if (pop1 == pop2) answer += 2;
                else {
                    stack.push(pop2);
                    stack.push(pop1);
                }
            }
        }
        return answer;
    }
}