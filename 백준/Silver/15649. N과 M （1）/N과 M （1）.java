import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int[] arr;
  static boolean[] visit;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    visit = new boolean[N+1];

    backTracking(0);
    System.out.println(sb);
  }

  private static void backTracking(int depth) {
    if (depth == M) { // 최고 깊이까지 도달한 경우
      for (int a : arr) {
        sb.append(a).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i=0; i<N; i++) {
      if (!visit[i]) { // 방문하지 않은 노드일 경우
        visit[i] = true; // 방문한 노드로 표시하고
        arr[depth] = i + 1; // 겹치지 않는 값으로 값 추가

        backTracking(depth + 1); // 하위 노드 확인

        visit[i] = false; // 백트래킹 종료 후 미방문 노드로 표시
      }
    }
  }
}