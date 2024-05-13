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