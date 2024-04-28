import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int M, N;
  static int[][] arr, dp;
  //상하좌우 좌표
  static int[] rangeX = {-1, 0, 1, 0};
  static int[] rangeY = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    //초기값 세팅
    arr = new int[M+1][N+1];

    for (int i=1; i<=M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=1; j<=N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp = new int[M+1][N+1];

    for (int i=1; i<=M; i++) {
      for (int j=1; j<=N; j++) {
        dp[i][j] = -1;
      }
    }

    bw.write(DFS(1, 1) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  private static int DFS(int x, int y) {
    //끝점에 도달했을 경우
    if (x == M && y == N) return 1;
    //이미 방문한 경우
    if (dp[x][y] != -1) return dp[x][y];

    dp[x][y] = 0; //현재 위치에서 끝점까지 도달하는 경로 개수 초기화

    for (int i=0; i<4; i++) {
      int dx = x + rangeX[i];
      int dy = y + rangeY[i];

      if (dx < 0 || dy < 0 || dx > M || dy > N) continue;

      //arr[x][y]보다 arr[dx][dy] 높이가 더 낮다면
      //arr[dx][dy]에서 끝점까지 도달하는 경로의 개수 더하기
      if (arr[x][y] > arr[dx][dy]) {
        dp[x][y] += DFS(dx, dy);
      }
    }

    return dp[x][y];
  }
}