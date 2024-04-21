import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int N = 64;
    int cnt = 0;

    while (true) {
      if (X == 1) {
        cnt++;
        break;
      } else if (X == 0) break;

      if (N > X) { // 길이가 X보다 길 경우 반 자르고 나머지 반 버리기
        N /= 2; // 반 자르기
      } else if (N < X) { // 길이가 X가 더 길 경우
        cnt++;
        X -= N; // 필요한 길이 다시 구하기
        N /= 2; // 반 자르기
      } else { // 동일할 경우
        cnt++;
        break;
      }
    }
    System.out.println(cnt);
  }
}