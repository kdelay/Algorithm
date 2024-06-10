import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * @param want 원하는 제품
     * @param number 원하는 제품의 수량 마트 할인 제품
     * @param discount 회원등록 날짜의 일수
     * @return
     */
    public static int solution(String[] want, int[] number, String[] discount) {

        Map<String, Integer> want_map = new HashMap<>();
        Map<String, Integer> dis_map;

        //초기 값 세팅
        for (int i = 0; i < want.length; i++) want_map.put(want[i], number[i]);

        int answer = 0;

        //회원 가입 최대 날짜 범위
        A: for (int i = 0; i <= discount.length-10; i++) {
            dis_map = new HashMap<>();

            //회원은 10개만 할인 받을 수 있음
            for (int j = i; j < i+10; j++) {
                //원하는 물건이 아닌 경우
                if (!want_map.containsKey(discount[j])) continue A;

                dis_map.put(discount[j], dis_map.getOrDefault(discount[j], 0) + 1);

                //연속적으로 일치가 안되는 경우(원하는 물건보다 개수가 많은 경우)
                if (dis_map.get(discount[j]) > want_map.get(discount[j])) continue A;
            }
            answer++;
        }
        return answer;
    }
}