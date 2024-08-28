import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> mbti = new HashMap<>();
        mbti.put('R', 0);
        mbti.put('T', 0);
        mbti.put('C', 0);
        mbti.put('F', 0);
        mbti.put('J', 0);
        mbti.put('M', 0);
        mbti.put('A', 0);
        mbti.put('N', 0);
        
        for (int i = 0; i < choices.length; i++) {
            //비동의
            if (choices[i] < 4) {
                char c = survey[i].charAt(0);
                mbti.put(c, (mbti.getOrDefault(c, 0) + (4 - choices[i])));
            } 
            //동의
            else if (choices[i] > 4) {
                char c = survey[i].charAt(1);
                mbti.put(c, (mbti.getOrDefault(c, 0) + (choices[i] - 4)));
            } else continue; //모르겠음
        }
        
        String answer = "";
        answer += (mbti.get('T') > mbti.get('R')) ? "T" : "R";
        answer += (mbti.get('F') > mbti.get('C')) ? "F" : "C";
        answer += (mbti.get('M') > mbti.get('J')) ? "M" : "J";
        answer += (mbti.get('N') > mbti.get('A')) ? "N" : "A";
        
        return answer;
    }
}