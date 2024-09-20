class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int len1 = arr1.length;
        int len1Sub = arr1[0].length;
        int len2 = arr2[0].length;
        
        int[][] result = new int[len1][len2];
        
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                for (int k = 0; k < len1Sub; k++) {
                    result[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }
        return result;
    }
}