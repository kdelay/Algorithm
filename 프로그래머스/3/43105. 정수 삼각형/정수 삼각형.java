class Solution {
    
    public int solution(int[][] triangle) {
        
        //최댓값 찾기 (bottom-up)
        for (int i = triangle.length-1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length-1; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        return triangle[0][0];
    }
}