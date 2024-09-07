import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        //초기 값 세팅
        Queue<Integer> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c - '0');
        }

        int zeroCnt = 0, answer = 0;
        while (queue.size() != 1) {
            //queue 에 0이 없을 때까지 진행
            int qs = 0;
            while (qs != queue.size()) {
                int cur = queue.poll();
                //0인 경우 제거하고, 제거된 0의 개수를 늘린다.
                if (cur == 0) zeroCnt++;
                //1인 경우 다시 queue 에 넣는다.
                else {
                    queue.add(cur);
                    qs++;
                }
            }
            //queue 크기를 가지고 2진수 진행
            int size = queue.size();
            //s 가 1인 경우 조기 종료
            if (size == 1) {
                answer++;
                break;
            }
            //새로운 값을 저장하기 위해 큐의 값을 초기화 시킨다.
            queue.clear();

            while (true) {
                //2를 나눈 나머지를 queue 에 넣기
                queue.add(size % 2);
                size /= 2;
                //1인 경우 중단
                if (size == 1) {
                    queue.add(size);
                    break;
                }
            }
            answer++;
        }
        return new int[]{answer, zeroCnt};
    }
}