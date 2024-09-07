import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        //초기 값 세팅
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int sco : scoville) {
            queue.add(sco);
        }

        //K 보다 작은 값인 경우만 동작
        int answer = 0;
        while (queue.peek() < K) {
            
            //queue 사이즈가 1인 경우 더이상 섞을 수 없음
            if (queue.size() == 1) return -1;
            
            //섞은 음식의 스코빌 지수
            int mixed = queue.poll() + (queue.poll() * 2);
            queue.add(mixed);
            answer++;
        }
        return answer;
    }
}