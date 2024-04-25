import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int result = 0;
    while (N % 5 != 0) { // 5kg 봉지에 담을 수 없는 경우
      N -= 3; // 3kg에 모두 담기
      result++;
    }

    if (N < 0) { // Nkg를 완벽하게 담을 수 없는 경우
      System.out.println(-1);
      return;
    } else {
      // 5kg에 담을 수 있는 경우 모두 담기
      result += (N / 5);
    }
    System.out.println(result);
  }
}