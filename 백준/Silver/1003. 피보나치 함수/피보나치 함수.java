import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[][] arr;
  static int[] f;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      arr = new int[N+2][2];
      f = new int[N+1];

      fibo(N);
      sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
    }
    System.out.println(sb);
  }

  private static int fibo(int N) {

    // under value
    if (N == 0) {
      arr[0][0] = 1;
      arr[0][1] = 0;
      return f[0] = 0;
    } else if (N == 1) {
      arr[1][0] = 0;
      arr[1][1] = 1;
      return f[1] = 1;
    }

    if (f[N] > 0) { // 이미 값이 설정되어 있는 경우
      return f[N];
    }

    f[N] = fibo(N-1) + fibo(N-2);
    arr[N][0] = arr[N-1][0] + arr[N-2][0]; // 0 호출 횟수
    arr[N][1] = arr[N-1][1] + arr[N-2][1]; // 1 호출 횟수
    return f[N];
  }
}