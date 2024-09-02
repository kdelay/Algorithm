class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        
        int row = park.length;
        int column = park[0].length();
        char[][] ground = new char[row][column];
        
        //초기 세팅
        int sx = 0, sy = 0;
        for (int i = 0; i < row; i++) {
            ground[i] = park[i].toCharArray();
            
            if (park[i].contains("S")) {
                sx = i;
                sy = park[i].indexOf("S");
            }
        }
        
        for (String route : routes) {
            char op = route.charAt(0);
            int n = Integer.parseInt(route.split(" ")[1]);
            
            int nx = sx, ny = sy;
            for (int i = 0; i < n; i++) {
                if (op == 'E') ny++;
                if (op == 'W') ny--;
                if (op == 'S') nx++;
                if (op == 'N') nx--;
                
                //범위 내여야 함
                if (nx >= 0 && ny >= 0 && nx < ground.length && ny < ground[0].length) {
                    //장애물 유무 확인
                    if (ground[nx][ny] == 'X') break;
                    if (i == n-1) {
                        sx = nx;
                        sy = ny;
                    }
                    
                }
            }
        }
        return new int[]{sx, sy};
    }
}