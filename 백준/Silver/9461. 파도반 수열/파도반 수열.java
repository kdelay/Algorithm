import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static long[] dp = new long[101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;

    for (int i=0; i<T; i++) {
      int a = Integer.parseInt(br.readLine());
      sb.append(method(a)).append("\n");
    }
    System.out.println(sb);
  }

  private static long method(int a) {
    if (dp[a] == 0) {
      dp[a] = method(a-2) + method(a-3);
    }
    return dp[a];
  }
}