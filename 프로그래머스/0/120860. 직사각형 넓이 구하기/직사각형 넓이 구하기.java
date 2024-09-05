class Solution {
    public int solution(int[][] dots) {
        
        int lx = 256, ly = -256, rx = -256, ry = 256;
        for (int i = 0; i < dots.length; i++) {
            lx = Math.min(lx, dots[i][0]);
            ly = Math.max(ly, dots[i][1]);
            rx = Math.max(rx, dots[i][0]);
            ry = Math.min(ry, dots[i][1]);
        }
        return Math.abs((rx - lx) * (ry - ly));
    }
}