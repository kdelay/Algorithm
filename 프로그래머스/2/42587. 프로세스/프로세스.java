import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        //우선 순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        //초기 값
        for (int p : priorities) {
            queue.add(p);
        }
        
        //큐가 빌 때까지 진행
        int answer = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                //동일한 값인 경우만 제거 가능
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++; //실행 횟수 추가
                    
                    //target 번호와 동일할 경우 종료
                    if (location == i) return answer;
                }
            }
        }
        return answer;
    }
}