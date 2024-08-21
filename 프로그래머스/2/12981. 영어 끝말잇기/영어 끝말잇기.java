import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        char preWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {

            //이미 나온 단어를 말하거나 잘못 이어 말한 경우
            if (set.contains(words[i]) || words[i].charAt(0) != preWord) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            //사용 단어 출가
            set.add(words[i]);
            
            //마지막 글자 업데이트
            preWord = words[i].charAt(words[i].length() - 1);
        }
        return new int[]{0, 0};
    }
}