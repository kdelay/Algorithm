import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            //범위 만큼 자름
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp); //오름차순 정렬
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}