import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      char[] a = br.readLine().toCharArray();
      char[] b = br.readLine().toCharArray();

      int lenA = a.length;
      int lenB = b.length;
      int[][] dp = new int[lenA+1][lenB+1];

      for (int i=1; i<=lenA; i++) {
        for (int j=1; j<=lenB; j++) {
          if (a[i-1] == b[j-1]) { //동일한 문자일 경우 대각선 값+1 저장
            dp[i][j] = dp[i-1][j-1] + 1;
          } else { //다른 문자일 경우 상좌 데이터 중 큰 수 저장
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
          }
        }
      }
      System.out.println(dp[lenA][lenB]);
    }
}