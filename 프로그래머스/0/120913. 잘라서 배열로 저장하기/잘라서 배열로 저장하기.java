import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        
        List<String> answer = new ArrayList<>();
        
        int start = 0;
        while (start < my_str.length()) {
            int end = Math.min(start + n, my_str.length());
            answer.add(my_str.substring(start, end));
            start += n;
        }
        return answer.stream().toArray(String[]::new);
    }
}