import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++) {
            answer[i] = action(array, commands[i]);
            
        }
        return answer;
    }
    
    
    
    public int action(int[] array, int[] command) {
        int i = command[0];
        int j = command[1];
        int k = command[2];
        int len = j - i + 1;
        int[] res = new int[len];
        
        for(int a = 0; a < len; a++) {
            res[a] = array[a + (i - 1)];
        }
        
        Arrays.sort(res);
        return res[k - 1];
        
    }
}