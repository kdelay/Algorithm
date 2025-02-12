import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) scores[0]++;
            if (two[i % two.length] == answers[i]) scores[1]++;
            if (three[i % three.length] == answers[i]) scores[2]++;
        }
        
        int maxScore = Arrays.stream(scores)
                .max()
                .orElse(0);

        return IntStream.range(0, scores.length)
                .filter(i -> scores[i] == maxScore)
                .map(i -> i + 1)
                .toArray();
    }
}