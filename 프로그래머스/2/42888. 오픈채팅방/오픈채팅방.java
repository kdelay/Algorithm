import java.util.*;

class Solution {
        /**
     * @param record 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열
     * @return 최종적으로 방을 개설한 사람이 보게 되는 메시지
     */
    public static String[] solution(String[] record) {

        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        HashMap<String, String> uid = new HashMap<>();

        for (String s : record) {
            String[] cmd = s.split(" ");
            if (cmd.length == 3) { //Enter 또는 Change인 경우
                uid.put(cmd[1], cmd[2]); //명령어, user id
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] cmd = s.split(" ");
            if (msg.containsKey(cmd[0])) {
                answer.add(uid.get(cmd[1]) + msg.get(cmd[0]));
            }
        }
        return answer.toArray(new String[0]);
    }
}