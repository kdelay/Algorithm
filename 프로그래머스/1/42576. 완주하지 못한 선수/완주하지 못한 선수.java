import java.util.HashMap;

class Solution {
    /**
     * @param participant 선수 이름
     * @param completion 완주한 선수 이름
     * @return 완주하지 못한 선수 이름
     */
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        //map 초기화
        for (String k : participant) {
            if (map.containsKey(k)) {
                int value = map.get(k) + 1;
                map.replace(k, value);
            } else {
                map.put(k, 1);
            }
        }
        
        for (String k : completion) {
            int value = map.get(k) - 1;
            map.replace(k, value);
        }

        //value가 0 이상이면 완주하지 못한 선수이다.
        String mem = "";
        for (String k : map.keySet()) {
            if (map.get(k) > 0) {
                mem = k;
            }
        }
        return mem;
    }
}