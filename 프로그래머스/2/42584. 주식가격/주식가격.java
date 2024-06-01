import java.util.*;

class Solution {
    /**
     *
     * @param prices 주식 가격이 담긴 원본 배열
     * @return 가격이 떨어지지 않은 기간(초)
     */
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int len = prices.length;
        int[] answers = new int[len];

        //stack 초기값 설정
        stack.push(0);

        for (int i = 1; i < len; i++) {
            //스택을 사용해 이전 가격과 현재 가격 비교
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                //주식 가격이 떨어진 경우
                int idx = stack.pop();
                answers[idx] = i - idx;
            }
            stack.push(i);
        }
        
        //주식 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answers[idx] = len - 1 - idx;
        }
        return answers;
    }
}