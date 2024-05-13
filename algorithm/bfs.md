# 너비 우선 탐색 BFS(Breadth-First-Search)
- `Queue`로 인덱스를 탐색한다.
- visited로 방문 노드를 표시할 수 있다.
- `최단 거리`를 찾을 수 있다.


<details>
  <summary>미로 찾기</summary>

  [미로 찾기](https://github.com/kdelay/Algorithm/tree/main/%EB%B0%B1%EC%A4%80/Silver/2178.%E2%80%85%EB%AF%B8%EB%A1%9C%E2%80%85%ED%83%90%EC%83%89)
  
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(arr[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int px = poll[0];
            int py = poll[1];

            for (int i=0; i<4; i++) {
                int a = px + dx[i];
                int b = py + dy[i];

                if (a >= 0 && b >= 0 && a < N && b < M && arr[a][b] == 1 && !visited[a][b]) {
                    queue.add(new int[]{a, b});
                    visited[a][b] = true;
                    arr[a][b] = arr[px][py] + 1; //도착할 수 있는 경우의 수 증가
                }
            }
        }

    }
}
```
</details>

<details>
  <summary>숨바꼭질</summary>

  [숨바꼭질](https://www.acmicpc.net/problem/1697)

  ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int visited[] = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            //값을 찾은 경우 반환
            if (poll == K) return visited[poll] - 1;

            //범위 내에 있고, 방문한 적 없는 경우 진행
            if (poll-1 >= 0 && visited[poll-1] == 0) {
                visited[poll-1] = visited[poll] + 1;
                queue.add(poll-1);
            }
            if (poll+1 <= 100000 && visited[poll+1] == 0) {
                visited[poll+1] = visited[poll] + 1;
                queue.add(poll+1);
            }
            if (poll*2 <= 100000 && visited[poll*2] == 0) {
                visited[poll*2] = visited[poll] + 1;
                queue.add(poll*2);
            }
        }
        return -1;
    }
}
  ```
</details>
