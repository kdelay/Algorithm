import java.util.*;

class Solution {
    /**
     * @param id_list 유저 ID
     * @param report 유저가 신고한 ID
     * @param k k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송한다.
     * @return 정지 사실을 메일로 받은 횟수 배열
     */
    public static int[] solution(String[] id_list, String[] report, int k) {

        //신고당한 유저 - 신고 유저 집합을 저장할 해시맵
        Map<String, Set<String>> reportedUser = new HashMap<>();

        //처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        Map<String, Integer> count = new HashMap<>();

        //신고 기록 순회
        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            //신고당한 기록이 없는 경우
            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }

            //신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUser.get(reportedId).add(userId);
        }

        for (Map.Entry<String, Set<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) { //정지 기준에 만족하는지 확인
                for (String uid : entry.getValue()) { //해시셋을 순회하며 count 계산
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        //각 아이디별 메일을 받은 횟수를 순서대로 정리
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}