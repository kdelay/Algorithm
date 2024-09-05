class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
        int x = 0, y = 0;
        int bx = board[0]/2, by = board[1]/2;
        
        for (String key : keyinput) {
            if (key.equals("up")) y++;
            else if (key.equals("down")) y--;
            else if (key.equals("left")) x--;
            else if (key.equals("right")) x++;
            
            if (x < 0 && x < (bx * -1)) x = (bx * -1);
            else if (x > 0 && x > bx) x = bx;
        
            if (y < 0 && y < (by * -1)) y = (by * -1);
            else if (y > 0 && y > by) y = by;
        }
        return new int[]{x, y};
    }
}