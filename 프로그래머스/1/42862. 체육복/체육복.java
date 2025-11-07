import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> map = new HashMap<>();
        // 1. 초기화
        for (int i = 1; i <= n; i++) {
            map.put(i, 1);
        }
        // 2. 여유분
        for (int r : reserve) {
            map.put(r, map.get(r) + 1);
        }
        // 3. 도난
        for (int l : lost) {
            map.put(l, map.get(l) - 1);
        }

        // 4. 체육복 빌려주기 (학생이 0개일 때)
        for (int i = 1; i <= n; i++) {
            // 이 학생이 0개야?
            if (map.get(i) == 0) {
                
                // 1순위: 앞 학생 확인 (경계 체크 먼저!)
                // (i > 1)로 0번 학생을 확인하는 것을 방지
                if (i > 1 && map.get(i - 1) == 2) {
                    map.put(i, 1);      // 0 -> 1 (받음)
                    map.put(i - 1, 1);  // 2 -> 1 (줌)
                } 
                // 2순위: (앞 학생에게 못 받았으면) 뒷 학생 확인 (경계 체크 먼저!)
                // (i < n)으로 n+1번 학생을 확인하는 것을 방지
                else if (i < n && map.get(i + 1) == 2) {
                    map.put(i, 1);      // 0 -> 1 (받음)
                    map.put(i + 1, 1);  // 2 -> 1 (줌)
                }
            }
        }

        // 5. 최종 카운트 (요청하신 부분 수정 완료)
        int answer = 0;
        for (int suitCount : map.values()) {
            // 체육복이 1개 이상인 학생만 카운트
            if (suitCount > 0) {
                answer++;
            }
        }
        return answer;
    }
}