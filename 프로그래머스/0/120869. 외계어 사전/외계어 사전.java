import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (String d : dic) {
        
            //spell 값 초기화
            for (String s : spell) {
                map.put(s.charAt(0), 0);
            }
            
            for (int i = 0; i < d.length(); i++) {
                char c = d.charAt(i);
                
                if (map.containsKey(c)) {
                    map.replace(c, map.get(c) + 1);
                }
            }

            int cnt = 0;
            for (char c : map.keySet()) {
                if (map.get(c) > 0) cnt++;
            }
            if (cnt == map.size()) return 1;
        }
        return 2;
    }
}