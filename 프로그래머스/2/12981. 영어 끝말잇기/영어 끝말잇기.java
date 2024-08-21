import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {

        int[] result = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            //사람 번호
            int person = (i % n) + 1;
            //차례 번호
            int count = (i / n) + 1;

            String before = words[i - 1];
            String now = words[i];

            //이미 나온 단어를 말한 경우
            if (set.contains(now)) {
                result[0] = person;
                result[1] = count;
                return result;
            }

            set.add(now);
            int index = before.length() - 1;
            char first = now.charAt(0);
            char last = before.charAt(index);

            //잘못 이어 말한 경우
            if (last != first) {
                result[0] = person;
                result[1] = count;
                return result;
            }
        }
        return result;
    }
}