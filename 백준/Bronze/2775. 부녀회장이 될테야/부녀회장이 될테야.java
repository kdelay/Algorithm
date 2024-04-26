import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int K = Integer.parseInt(br.readLine());
      int N = Integer.parseInt(br.readLine());

      int[][] dp = new int[K+1][N];

      // 초기값 세팅
      // 0층에 사는 사람 (0층 1호 = 1명)
      for (int i=0; i<N; i++) {
        dp[0][i] = i+1;
      }
      // 1호에 사는 사람은 1명
      for (int i=1; i<=K; i++) {
        dp[i][0] = 1;
      }

      for (int i=1; i<=K; i++) {
        for (int j=1; j<N; j++) {
          dp[i][j] = dp[i][j-1] + dp[i-1][j];
        }
      }
      System.out.println(dp[K][N-1]);
    }
  }
}