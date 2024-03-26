import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
    Map<String, Integer> player = new HashMap<>();
    Map<Integer, String> rank = new HashMap<>();
    String[] answer = new String[players.length];

    // 초기화
    for (int i=0; i<players.length; i++) {
      player.put(players[i], i+1);
      rank.put(i+1, players[i]);
    }

    // 추월 logic
    for (int i=0; i<callings.length; i++) {
      int p_value = player.get(callings[i]); // 추월한 사람의 value
      String p = rank.get(p_value); // 추월한 사람
      String front_p = rank.get(p_value - 1); // 추월당한 앞 사람

      // swap 등수 변경
      // 추월 한 사람
      player.put(p, player.get(front_p));
      rank.put(p_value - 1, p);
      // 추월 당한 사람
      player.put(front_p, player.get(p) + 1);
      rank.put(p_value, front_p);
    }

    for (int i=0; i<rank.size(); i++) answer[i] = rank.get(i+1);
    return answer;
    }
}