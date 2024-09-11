import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (s / n == 0) return new int[]{-1};
        
        int[] answer = new int[n];
        
        //몫 분배
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }
        
        //나머지 분배
        for (int i = 0; i < s % n; i++) {
            answer[i] += 1;
        }
        
        //정렬
        Arrays.sort(answer);
        return answer;
    }
}