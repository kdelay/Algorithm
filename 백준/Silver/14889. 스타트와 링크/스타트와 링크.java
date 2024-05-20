import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N, min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(min);
    }

    private static void combi(int idx, int count) {
        //팀 구성원이 다 찬 경우
        if (count == N/2) {
            //차이 값 계산 후 min 구하기
            diff();
            return;
        }

        for (int i=idx; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {

        int startTeam = 0;
        int linkTeam = 0;

        for (int i=0; i<=N-2; i++) {
            for (int j=i+1; j<=N-1; j++) {
                //각 팀에 해당하는 능력치 합산
                if (visited[i] && visited[j]) startTeam += arr[i][j] + arr[j][i];
                if (!visited[i] && !visited[j]) linkTeam += arr[i][j] + arr[j][i];
            }
        }

        int m = Math.abs(startTeam - linkTeam);

        //가장 낮은 최솟값(0)인 경우 출력 후 종료
        if (m == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(m, min);
    }
}