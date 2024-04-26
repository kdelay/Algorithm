import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());
    System.out.println(dynamic(N, 0));
  }

  private static int dynamic(long N, int count) {
    // 1인 경우
    if (N < 2) return count;

    return Math.min(
        dynamic(N/2, (int) (count+1+(N%2))),
        dynamic(N/3, (int) (count+1+(N%3)))
    );
  }
}