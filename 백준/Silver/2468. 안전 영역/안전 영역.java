import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int maxHeight = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }

        int max = 0;
        //모든 지역 탐색
        for (int h=0; h<maxHeight+1; h++) {
            visited = new boolean[N][N];

            int rain = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {

                    if (arr[i][j] > h && !visited[i][j]) {
                        rain += dfs(i, j, h);
                    }
                }
            }
            max = Math.max(max, rain);
        }

        System.out.println(max);
    }

    private static int dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (a >= 0 && b >= 0 && a < N && b < N && arr[a][b] > h && !visited[a][b]) {
                dfs(a, b, h);
            }
        }
        return 1;
    }
}