import java.util.*;

class Solution {
        /**
     * @param progresses (배포되어야 하는 순서) 작업의 진도
     * @param speeds 작업 개발 속도
     * @return 배포마다 몇 개의 기능이 배포되는지
     */
    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        //작업의 진도 순회
        for (int i = 0; i < progresses.length; i++) {

            //진도율이 100 미만인 경우, 작업 진행
            int day = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                day++;
            }

            //배포 가능한 경우
            if (progresses[i] >= 100) {
                //스택이 비어있는 경우, 작업 기간 push
                if (queue.isEmpty()) queue.push(day);
                //이전 기능 작업 소요 기간이 계산된 경우
                else {
                    //다음 작업 기간이 작은 경우 배포 불가
                    if (queue.peek() > day) {
                        queue.push(queue.peek());
                    } else { //스택 맨 위의 값보다 다음 작업 기간이 더 긴 경우
                        queue.push(day);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int pop = queue.removeLast();

            if (map.containsKey(pop)) {
                int value = map.get(pop) + 1;
                map.put(pop, value);
            } else map.put(pop, 1);
        }

        List<Integer> list = new ArrayList<>();

        for (Integer k : map.keySet()) {
            list.add(map.get(k));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}