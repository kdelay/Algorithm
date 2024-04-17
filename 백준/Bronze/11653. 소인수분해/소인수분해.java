import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int a = 2;

    if (N == 1) return;

    while (true) {
      if (N == a) { // 몫이 1이라면 a값 추가하고 break
        sb.append(a);
        break;
      }
      if (N % a != 0) { // 나누어 떨어지지 않는 수일 경우 a값 증가
        a++;
      } else {
        N /= a;
        sb.append(a).append("\n");
      }
    }
    System.out.print(sb);
  }
}