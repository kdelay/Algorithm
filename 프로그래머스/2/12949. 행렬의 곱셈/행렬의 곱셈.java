/**
 * 행렬 곱셈 A[m][n] * B[n][k] -> 새로운 행렬 C[m][k]
 * arr1, arr2의 각 행렬 길이를 구한다.
 * 값을 저장할 새로운 행렬을 만든다.
 * arr1 열 길이만큼 * arr2 행 길이만큼 반복하고, 각 수를 곱한 후 더한다.
 */
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        int[][] arr3 = new int[r1][c2];

        for (int i=0; i<r1; i++) {

            //행렬 핵심 로직
            for (int j=0; j<c2; j++) {
                for (int k=0; k<c1; k++) {
                    arr3[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
            
        }
        return arr3;
    }
}