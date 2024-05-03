import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr, result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M]; //지도
        result = new int[N][M]; //거리
        visited = new boolean[N][M]; //방문 여부

        int x = 0, y = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                //목표 지점(2인 경우)
                if(arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
                //갈 수 없는 땅(0인 경우)
                else if (arr[i][j] == 0) visited[i][j] = true;
            }
        }

        bfs(x, y);

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                //도달할 수 없는 위치인 경우
                if(!visited[i][j]) {
                    result[i][j] = -1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            for (int i=0; i<4; i++) {
                //현재 위치 + {상하좌우}
                int a = tmp[0] + dx[i];
                int b = tmp[1] + dy[i];
                //갈 수 있는 경로인 경우
                if (a >= 0 && a < N && b >= 0 && b < M) {
                    //방문하지 않았고, 갈 수있는 땅(1인 경우)
                    if (!visited[a][b] && arr[a][b] == 1) {
                        visited[a][b] = true;
                        result[a][b] = result[tmp[0]][tmp[1]] + 1;
                        queue.add(new int[] {a, b});
                    }
                }
            }
        }
    }
}