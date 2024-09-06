class Solution {
    public int solution(int[][] board) {
        
        int len = board.length;
        int[][] bomb = new int[len+2][len+2];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                //폭탄이 있는 경우
                if (board[i][j] == 1) {
                    //범위만큼 접근 불가
                    for (int x = i; x < i+2; x++) {
                        for (int y = j; y < j+2; y++) {
                            if (bomb[x][y] != 1) bomb[x][y] = 1;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < bomb.length-1; i++) {
            for (int j = 1; j < bomb.length-1; j++) {
                if (bomb[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}