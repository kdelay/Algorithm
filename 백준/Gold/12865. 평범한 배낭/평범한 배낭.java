import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    //[0]kg, [1]Value
    int[][] arr = new int[N+1][3];
    int[][] dp = new int[N+1][K+1];

    for (int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken()); //Weight
      arr[i][1] = Integer.parseInt(st.nextToken()); //Value
    }

    //under value
    for (int i=arr[1][1]; i<=K; i++) {
      dp[0][i] = arr[1][2];
    }

    for (int i=1; i<=N; i++) {
      for (int j=1; j<=K; j++) {
        if ((j-arr[i][0]) < 0) { //배낭 kg 초과 시
          dp[i][j] = dp[i-1][j]; //kg의 최댓값
        } else {
          dp[i][j] = Math.max(
              dp[i-1][j], //kg의 최댓값
              arr[i][1] + dp[i-1][(j-arr[i][0])] //현재 비교하는 가치값 + 추가적으로 비교할 수 있는 kg의 가치값
          );
        }
      }
    }
    System.out.println(dp[N][K]);
  }
}