import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int w, h;

    static int[][] map;
    static List<Integer> island;

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        island = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            //종료 조건
            if (w == 0 && h == 0) break;

            //초기값
            map = new int[h+2][w+2];
            for (int i=1; i<=h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i=1; i<=h; i++) {
                for (int j=1; j<=w; j++) {
                    //섬이 있는 경우
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y) {
        //종료 조건
        if(map[x][y] == 0) return;

        map[x][y] = 0; //visited 대신에 0 대입

        for (int i=0; i<8; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            bfs(a, b);

        }
    }
}