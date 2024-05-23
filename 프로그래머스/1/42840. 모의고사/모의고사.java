import java.util.ArrayList;
import java.util.Arrays;

/**
 * 수포자들의 패턴을 저장해둔다.
 * 수포자들의 점수를 저장할 배열을 선언한다.
 * 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인한다.
 * - 문제 수보다 패턴 수가 적은 경우는 패턴 수를 반복한다.
 * 가장 높은 점수를 저장한다.
 * 가장 높은 점수를 가진 수포자들의 번호를 찾아서 오름차순으로 리스트에 담는다.
 * int 배열로 반환한다.
**/

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i=0; i<answers.length; i++) {
            for (int j=0; j<pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}