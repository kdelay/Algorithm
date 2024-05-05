import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int w, h, landNum = 0;

    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> island;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        island = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            //종료 조건
            if (w == 0 && h == 0) {
                for (int i : island) System.out.println(i);
                return;
            }

            //초기값
            arr = new int[h][w];
            visited = new boolean[h][w];
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    //섬이 있고 아직 방문하지 않은 경우
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                        landNum++;
                    }
                }
            }
            island.add(landNum);
            landNum = 0;
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int px = poll[0];
            int py = poll[1];
            int[] nx = {px-1, px-1, px+1, px+1};
            int[] ny = {py-1, py+1, py-1, py+1};


            for (int i=0; i<4; i++) {
                //상하좌우
                int a = px + dx[i];
                int b = py + dy[i];
                //대각선
                int c = nx[i];
                int d = ny[i];

                //같은 섬인 경로가 있고, 방문하지 않은 섬인 경우
                if (a >= 0 && b >= 0 && a < h && b < w && !visited[a][b] && arr[a][b] == 1) {
                    queue.add(new int[] {a, b});
                    visited[a][b] = true;
                }
                if (c >= 0 && d >= 0 && c < h && d < w && !visited[c][d] && arr[c][d] == 1) {
                    queue.add(new int[] {c, d});
                    visited[c][d] = true;
                }
            }
        }
    }
}