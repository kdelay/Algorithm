import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    if (N < 100) {
      System.out.println(N);
    } else {
      int h = 99;
      for (int i=100; i<=N; i++) {
        int hun = i/100;
        int ten = (i/10)%10;
        int one = i%10;

        if ((hun - ten) == (ten - one)) { // 한수
          h++;
        }
      }
      System.out.println(h);
    }
  }
}