import java.util.Arrays;

class Solution {
    public static String[] solution(String[] quiz) {

        String[] answer = new String[quiz.length];
        String[] q = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {

            q = quiz[i].split(" ");

            if (q[1].equals("-")) {
                if (Integer.parseInt(q[0]) - Integer.parseInt(q[2]) == Integer.parseInt(q[4])) {
                    answer[i] = "O";
                } else  answer[i] = "X";
            }

            if (q[1].equals("+")) {
                if (Integer.parseInt(q[0]) + Integer.parseInt(q[2]) == Integer.parseInt(q[4])) {
                    answer[i] = "O";
                } else  answer[i] = "X";
            }
        }
        return answer;
    }
}