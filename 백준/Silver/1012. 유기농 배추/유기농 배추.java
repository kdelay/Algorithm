import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] arr;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T -- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            while (K -- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }

            int cnt = 0;
            for (int i=0; i<M; i++) {
                for (int j=0; j<N; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y) {
        if (arr[x][y] == 0) return;
        arr[x][y] = 0;

        for (int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (a >= 0 && b >= 0 && a < M && b < N && arr[a][b] == 1) {
                dfs(a, b);
                arr[a][b] = 0;
            }
        }
    }
}