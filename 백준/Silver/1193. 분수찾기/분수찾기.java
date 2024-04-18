import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int T = 1, sum = 0;

    while (true) {
      if (X <= T + sum) {
        // 대각선 범위 내로 접근할 경우
        if (T % 2 == 1) { // T가 홀수인 경우, (오른쪽위->왼쪽아래 방향)
          // 분자 (T - (X - sum - 1)
          // 분모 (X - sum)
          System.out.println((T - (X - sum - 1) + "/" + (X - sum)));
          break;
        }
        else { // T가 짝수인 경우, (왼쪽아래->오른쪽위 방향)
          // 분자 (X - sum)
          // 분모 (T - (X - sum - 1)
          System.out.println((X - sum) + "/" + (T - (X - sum - 1)));
          break;
        }
      }
      else {
        // 대각선 범위 내가 아닐 경우
        sum += T;
        T++;
      }
    }
  }
}