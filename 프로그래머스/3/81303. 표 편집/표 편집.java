import java.util.*;

class Solution {
    /**
     * @param n 처음 표의 행 개수
     * @param k 처음에 선택된 행의 위치
     * @param cmd 수행한 명령어들이 담긴 문자열 배열
     * @return 삭제 유무 행 O,X로 표시한 문자열 형태
     */
    public static String solution(int n, int k, String[] cmd) {
        //삭제된 행을 저장하는 스택
        Stack<Integer> deleted = new Stack<>();

        //각 행을 기준으로 연산에 따른 위치 표시 up, down
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        //상대적 위치에 따른 행 번호 설정
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        //가상 공간에 맞추기 위해 현재 위치 +1
        k++;

        //cmd 순회
        for (String c : cmd) {
            //현재 위치를 삭제하고 그 다음 위치로 이동
            if (c.startsWith("C")) {
                //stack에 저장
                deleted.push(k);
                //up과 down이 바라보는 행 번호 변경
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                //n을 넘는 경우는 바닥이므로 위의 행을 선택해야 한다. 그 외는 행을 하나씩 증가 시킨다.
                k = n < down[k] ? up[k] : down[k];
            }
            //가장 최근에 삭제된 행 번호 복원
            else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            //행 번호 이동
            else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);

                //x 횟수만큼 진행
                for (int i = 0; i < x; i++) {
                    //U인 경우 up, D인 경우 down
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        //삭제된 행의 위치에 'X', 그렇지 않은 행 위치에는 'O'를 저장한 문자열 반환
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        //stack에 남아있는 행은 삭제된 행이다.
        for (int i : deleted) {
            answer[i-1] = 'X';
        }
        return new String(answer);
    }
}