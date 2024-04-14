import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[] dp;
  static int[] stair;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    stair = new int[N + 1];
    dp = new int[N + 1];

    // 초기 값 세팅 (1 ~ N)
    for (int i=1; i<N+1; i++) stair[i] = Integer.parseInt(br.readLine());
    for (int i=0; i<N+1; i++) dp[i] = -1;
    dp[0] = 0;
    dp[1] = stair[1];
    if (N == 1) {
      System.out.println(dp[N]);
      return;
    }
    dp[2] = stair[1] + stair[2];

    System.out.println(sum(N));
  }

  public static int sum(int N) {
    if (dp[N] == -1) { // 값이 세팅되어있지 않은 경우
      // (2칸 오르기 vs 3칸 뒤까지의 값 + 1칸 오르기) + 현재 서있는 계단 값
      dp[N] = Math.max( sum(N-2), sum(N-3)+stair[N-1] ) + stair[N];
    }
    return dp[N];
  }
}