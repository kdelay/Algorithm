import java.util.*;

public class Solution {
    /**
     * @param arr 배열
     * @return 중복 숫자 없이 배열 반환
     */
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();

        for (int a : arr) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (stack.peek() != a) {
                    stack.push(a);
                }
            }
        }
        return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}