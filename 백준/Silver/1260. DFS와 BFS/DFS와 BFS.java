import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] node;
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());

      node = new int[N+1][N+1];
      visitedDFS = new boolean[N+1];
      visitedBFS = new boolean[N+1];
      for (int i=0; i<M; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //간선 연결
        node[a][b] = node[b][a] = 1;
      }
      dfs(V);
      System.out.println();
      bfs(V);
    }

    private static void dfs(int V) {
      visitedDFS[V] = true; //노드 방문
      System.out.print(V + " "); //방문한 노드 출력

      //인접 노드 순회
      for (int i=1; i<=N; i++) {
        //방문한 적 없고 1인 경우
        if (!visitedDFS[i] && node[V][i] != 0) {
          dfs(i);
        }
      }
    }

    private static void bfs(int V) {
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(V); //시작점
      visitedBFS[V] = true; //노드 방문
      System.out.print(V + " "); //방문한 노드 출력

      //queue가 빌 때까지 반복
      while(!queue.isEmpty()) {
        int tmp = queue.poll();

        //인접 노드 순회
        for (int i=1; i<=N; i++) {
          //방문한 적 없고 1인 경우
          if(!visitedBFS[i] && node[tmp][i] != 0) {
            queue.offer(i); //큐에 삽입
            visitedBFS[i] = true; //노드 방문
            System.out.print(i + " "); //방문한 노드 출력
          }
        }
      }
    }
}