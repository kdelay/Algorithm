import java.util.*;

class Solution {
    /**
     * @param msg 문자열
     * @return map key 배열
     */
    public static int[] solution(String msg) {

        Map<String, Integer> alphabet = new LinkedHashMap<>();
        //알파벳 초기화
        for (int i = 0; i < 26; i++) {
            alphabet.put(String.valueOf((char)('A' + i)), i+1);
        }

        List<Integer> result = new ArrayList<>();
        int idx = 0;

        //msg 문자열 길이 -1 만큼 진행
        while (idx < msg.length()-1) {
            String cur = "";
            String pre = String.valueOf(msg.charAt(idx));

            for (int i = 1; idx+i <= msg.length(); i++) {
                cur = msg.substring(idx, idx+i);
                if (!alphabet.containsKey(cur)) {
                    alphabet.put(cur, alphabet.size()+1);
                    break;
                }
                pre = cur;
            }

            result.add(alphabet.get(pre));
            idx = idx + pre.length();
        }

        if (idx == msg.length()-1) {
            result.add(alphabet.get(String.valueOf(msg.charAt(idx))));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}