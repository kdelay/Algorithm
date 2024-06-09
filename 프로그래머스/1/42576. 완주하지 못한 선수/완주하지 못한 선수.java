import java.util.HashMap;

class Solution {
    /**
     * @param participant 선수 이름
     * @param completion 완주한 선수 이름
     * @return 완주하지 못한 선수 이름
     */
    public String solution(String[] participant, String[] completion) {
        
        String mem = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
        for (String p : completion) map.put(p, map.get(p) - 1);

        for (String k : map.keySet()) {
            if (map.get(k) != 0) mem = k;
        }

        return mem;
    }
}