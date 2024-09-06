import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        for (String d : dic) {
            int answer = 0;
            
            for (String s : spell) {
                if (d.contains(s)) answer++;
            }
            
            if (answer == spell.length) return 1;
        }
        return 2;
    }
}