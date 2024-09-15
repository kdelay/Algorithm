import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        //정답 횟수
        int[] answer = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (one[i % 5] == answers[i]) answer[0]++;
            if (two[i % 8] == answers[i]) answer[1]++;
            if (three[i % 10] == answers[i]) answer[2]++;
        }
        
        //최댓 값 찾기
        int max = answer[0];
        for (int i = 1; i <= 2; i++) {
            max = Math.max(max, answer[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max <= answer[i]) list.add(i+1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}