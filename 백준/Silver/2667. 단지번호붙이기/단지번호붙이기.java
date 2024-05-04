import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, house = 1;

    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> danzi;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N]; //지도
        visited = new boolean[N][N]; //방문 노드 확인
        danzi = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                //집이 있고, 방문하지 않은 곳에 dfs 진행
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    danzi.add(house); //단지 내 가구 수 저장
                    house = 1; //가구 수 1개로 초기화
                }
            }
        }

        //오름차순 정렬
        Collections.sort(danzi);

        StringBuilder sb = new StringBuilder();
        sb.append(danzi.size()).append("\n"); //단지 수
        for (int d : danzi) sb.append(d).append("\n"); //단지 내 가구 수
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            //상하좌우 움직일 수 있는 좌표고, 방문하지 않은 집인 경우
            if (a >= 0 && b >= 0 && a < N && b < N &&
                !visited[a][b] && arr[a][b] == 1) {
                house++;
                dfs(a, b);
            }
        }
    }
}