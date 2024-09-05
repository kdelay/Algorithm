class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
        int[] loc = {0, 0};
        int bx = board[0]/2, by = board[1]/2;
        
        for (String key : keyinput) {
            if (key.equals("up")) loc[1] += (loc[1] < by) ? 1 : 0;
            else if (key.equals("down")) loc[1] -= (loc[1] > -by) ? 1 : 0;
            else if (key.equals("left")) loc[0] -= (loc[0] > -bx) ? 1 : 0;
            else if (key.equals("right")) loc[0] += (loc[0] < bx) ? 1 : 0;
        }
        return loc;
    }
}