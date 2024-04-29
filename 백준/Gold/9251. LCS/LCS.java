import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] str1 = br.readLine().toCharArray();
    char[] str2 = br.readLine().toCharArray();

    int length1 = str1.length;
    int length2 = str2.length;

    //공집합을 위한 배열 길이 1 추가
    int[][] dp = new int[length1+1][length2+1];

    //공집합 빼고 1부터 시작
    for (int i=1; i<=length1; i++) {
      for (int j=1; j<=length2; j++) {

        //(i-1), (j-1) 문자가 같다면
        if (str1[i-1] == str2[j-1]) {
          //대각선 위(i-1, j-1)의 dp에 +1 한 값으로 갱신
          dp[i][j] = dp[i-1][j-1] + 1;
        }

        //같지 않다면 이전 열(i-1), 이전 행(j-1) 중에 max값으로 갱신
        else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    System.out.println(dp[length1][length2]);
  }
}