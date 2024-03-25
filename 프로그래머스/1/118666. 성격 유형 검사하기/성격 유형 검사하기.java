import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
    Map<Character, Integer> score = new HashMap<>(); // 설문 항목별 점수 배열

    for (int i=0; i<survey.length; i++) {
      int value = choices[i];
      char ch;
      if (value > 0 && value < 4) { // 부정적인 답변인 경우
         ch = survey[i].charAt(0); // 첫 번째 요소를 key로 설정
        score.put(ch, score.getOrDefault(ch, 0) + 4 - value); // key의 value를 설정한다.
      } else if (value > 4) { // 긍정적인 답변인 경우
        ch = survey[i].charAt(1); // 두 번째 요소를 key로 설정
        score.put(ch, score.getOrDefault(ch, 0) + value - 4); // key의 value를 설정한다.
      }
    }

    return new StringBuilder() // 문자열 조합
        .append(score.getOrDefault('R', 0) >= score.getOrDefault('T', 0) ? 'R' : 'T')
        .append(score.getOrDefault('C', 0) >= score.getOrDefault('F', 0) ? 'C' : 'F')
        .append(score.getOrDefault('J', 0) >= score.getOrDefault('M', 0) ? 'J' : 'M')
        .append(score.getOrDefault('A', 0) >= score.getOrDefault('N', 0) ? 'A' : 'N')
        .toString();
    }
}