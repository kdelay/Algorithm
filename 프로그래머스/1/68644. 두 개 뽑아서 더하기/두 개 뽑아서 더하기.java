import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int tmp = numbers[i] + numbers[j];
                //값이 없을 때만 추가
                if (!set.contains(tmp)) set.add(tmp);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}