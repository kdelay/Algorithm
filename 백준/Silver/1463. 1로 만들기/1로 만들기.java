import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static Integer[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    dp = new Integer[N + 1];
    System.out.println(func(N, 0));
  }

  private static int func(int N, int count) {
    if (N < 2) return count;
    return Math.min( func(N/2, count+1+(N%2)), func(N/3, count+1+(N%3)) );
  }
}