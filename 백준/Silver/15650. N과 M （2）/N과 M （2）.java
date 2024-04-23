import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];

    backTracking(1, 0);
    System.out.println(sb);
  }

  private static void backTracking(int at, int depth) {
    if (depth == M) { // 최대 깊이까지 방문한 경우
      for (int a : arr) {
        sb.append(a).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i=at; i<=N; i++) {
      arr[depth] = i;
      backTracking(i + 1, depth + 1);
    }
  }
}