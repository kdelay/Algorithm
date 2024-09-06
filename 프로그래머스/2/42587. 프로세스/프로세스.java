import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> compare = new ArrayList<>();
        Queue<Integer> marking = new LinkedList<>();
        
        //초기 값
        for (int i = 0; i < priorities.length; i++) {
            marking.add((i == location) ? 1 : 0);
            queue.add(priorities[i]);
            compare.add(priorities[i]);
        }
        
        int count = 0, idx = 0;
        
        while (true) {
            //기준 값
            int cur = queue.poll();
            boolean tf = false;

            //우선 순위가 밀리는 것이 있는지 확인
            for (int j = 1; j < queue.size(); j++) {
                if (cur < compare.get(j)) {
                    tf = true;
                    break;
                }
            }
            //우선 순위가 밀리면 다시 큐에 넣는다.
            if (tf) {
                queue.add(cur);
                    
                compare.remove(0);
                compare.add(cur);

                int tmp = marking.poll();
                marking.add(tmp);
            }
            //실행할 수 있는 경우
            else {
                compare.remove(0);
                count++;
                //target 인 경우 종료
                if (marking.poll() == 1) return count;
            }
        }
    }
}