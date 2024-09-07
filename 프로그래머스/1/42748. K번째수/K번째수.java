import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        for (int co = 0; co < commands.length; co++) {
            int i = commands[co][0];
            int j = commands[co][1];

            //i~j까지 자름
            List<Integer> list = new ArrayList<>();
            for (int b = i-1; b <= j-1; b++) {
                list.add(array[b]);
            }
            //정렬
            Collections.sort(list);
            answer[co] = list.get(commands[co][2]-1);
        }
        return answer;
    }
}