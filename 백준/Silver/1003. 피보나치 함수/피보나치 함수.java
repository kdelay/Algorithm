import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[][] call;
  static int[] topDown_memo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i=0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());
      topDown_memo = new int[N+1];
      call = new int[N+2][2];

      fibonacci(N);
      sb.append(call[N][0]).append(" ").append(call[N][1]).append("\n");
    }
    System.out.println(sb);
  }

  public static int fibonacci(int N) {
    // 기저 상태 도달 시, 값 초기화 및 호출 횟수 저장
    if (N == 0) {
      call[0][0] = 1; // 0 값은 1개
      call[0][1] = 0; // 1 값은 0개
      return topDown_memo[0] = 0;
    }
    else if (N == 1) {
      call[1][0] = 0; // 0 값은 0개
      call[1][1] = 1; // 1 값은 1개
      return topDown_memo[1] = 1;
    }

    // 저장된 값이 있는 경우 그대로 사용
    if (topDown_memo[N] > 0) {
      return topDown_memo[N];
    }
    // 재귀 함수로 값 저장
    topDown_memo[N] = fibonacci(N-1) + fibonacci(N-2);
    call[N][0] = call[N-1][0] + call[N-2][0];
    call[N][1] = call[N-1][1] + call[N-2][1];
    return topDown_memo[N];
  }
}
