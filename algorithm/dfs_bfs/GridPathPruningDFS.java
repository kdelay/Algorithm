package dfs_bfs;

public class GridPathPruningDFS {
    static int[][] map = { // 각 위치의 이동 비용을 담고 있는 2차원 배열 (n: 맵 크기)
        {1, 3, 1},
        {2, 1, 2},
        {4, 3, 1}
    };
    static boolean[][] visited; // 방문 여부 기록
    static int n = 3;
    static int minCost = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        visited = new boolean[n][n];
        dfs(0, 0, map[0][0], ""); // (0, 0) 부터 탐색 시작. cost: map[0][0] = 1
        System.out.println("🔚 최종 최소 비용: " + minCost);
    }

    static void dfs(int x, int y, int cost, String path) {
        path += String.format("(%d,%d) → ", x, y);

        // * 프루닝 핵심 로직 *
        if (cost >= minCost) { // 현재 경로의 누적 비용이 현재 최소 비용보다 크거나 같으면, 더 이상 탐색하지 않고 재귀 호출 중단
            System.out.printf("🚫 프루닝: %s비용 %d ≥ 최소비용 %d\n", path, cost, minCost);
            return;
        }

        // 목표 지점 (2, 2) 에 도달하면, 누적 비용이 기존 비용보다 작을 경우 갱신
        if (x == n - 1 && y == n - 1) {
            System.out.printf("✅ 도착: %s비용 %d → 최소 갱신!\n", path, cost);
            minCost = Math.min(minCost, cost);
            return;
        }

        visited[x][y] = true;

        // 상하좌우 기준으로 다음 위치 탐색
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 이미 방문한 곳은 가지 않고, 경계 조건과 방문 여부를 체크한다.
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                dfs(nx, ny, cost + map[nx][ny], path);
            }
        }

        // 백트래킹 처리: DFS 는 재귀 호출이 끝나면 이전 상태로 되돌아가야 하기 때문에, 해당 위치의 방문 상태를 해제한다.
        visited[x][y] = false;
    }
}