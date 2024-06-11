import java.util.*;

class Solution {
    /**
     * @param record 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열
     * @return 최종적으로 방을 개설한 사람이 보게 되는 메시지
     */
    public static String[] solution(String[] record) {

        int len = record.length;

        //유저 아이디, 닉네임 담을 map
        Map<String, String> map = new HashMap<>();
        //명령어, 유저 아이디 담을 list
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String user_id = st.nextToken();

            switch (cmd) {
                case "Enter":
                    map.put(user_id, st.nextToken());
                    list.add(new String[]{cmd, user_id});
                    break;
                case "Leave":
                    list.add(new String[]{cmd, user_id});
                    break;
                case "Change":
                    map.replace(user_id, st.nextToken());
                    break;
            }
        }

        List<String> result = new ArrayList<>();

        for (String[] li : list) {
            String cmd = li[0];
            String user_id = li[1];

            if (cmd.equals("Enter")) {
                result.add(map.get(user_id) + "님이 들어왔습니다.");
            } else {
                result.add(map.get(user_id) + "님이 나갔습니다.");
            }
        }
        return result.toArray(new String[result.size()]);
    }
}