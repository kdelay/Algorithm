import java.util.*;

class Solution {
    /**
     * @param clothes 의상 배열[의상의 이름, 의상의 종류]
     * @return 서로 다른 옷의 조합의 수
     */
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();

        //의상 타입 별 개수 초기화
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        //옷을 고르는 경우 + 고르지 않는 경우 (의상 타입 별 옷 개수 + 1)
        int answer = 1;
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }
        //최소 1개는 입어야 하므로, 안 입는 경우 제외
        return answer - 1;
    }
}