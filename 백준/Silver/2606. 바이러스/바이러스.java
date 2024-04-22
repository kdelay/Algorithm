import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[][] com;
  static boolean[] virus;
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    int S = Integer.parseInt(br.readLine());

    com = new int[N+1][N+1];
    virus = new boolean[N+1];

    for (int i=0; i<S; i++) {
      st = new StringTokenizer(br.readLine());
      int c1 = Integer.parseInt(st.nextToken());
      int c2 = Integer.parseInt(st.nextToken());
      com[c1][c2] = com[c2][c1] = 1; // c1, c2 컴퓨터는 같은 네트워크 상에 연결되어 있다.
    }

    dfs(1);
    System.out.println(count-1); // 1번 컴퓨터 제외
  }

  private static void dfs(int c) {
    virus[c] = true;
    count++;

    for (int i=1; i<=N; i++) { // 컴퓨터가 웜 바이러스에 걸렸는지 확인
      // 컴퓨터가 같은 네트워크 상에 연결되어 있고, 바이러스가 걸린 상태가 아니라면 하위 노드 확인
      if (com[c][i] == 1 && !virus[i]) dfs(i);
    }
  }
}