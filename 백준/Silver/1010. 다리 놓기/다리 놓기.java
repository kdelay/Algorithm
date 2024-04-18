import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int A = Integer.parseInt(br.readLine());
    int[][] dp = new int[31][31];

    // 초기 값 세팅
    for (int i=1; i<=30; i++) {
      dp[1][i] = i;
    }

    for (int i=2; i<=30; i++) {
      for (int j=i; j<=30; j++) {
        for (int k=j-1; k>=1; k--) {
          dp[i][j] += dp[i-1][k];
        }
      }
    }

    // 테스트
    for (int i=0; i<A; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      System.out.println(dp[N][M]);
    }
  }
}