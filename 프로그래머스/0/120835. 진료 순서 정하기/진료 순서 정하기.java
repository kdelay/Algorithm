import java.util.Arrays;
import java.util.Collections;

class Solution {
public int[] solution(int[] emergency) {
        int[] important = Arrays.stream(emergency)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] == important[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}