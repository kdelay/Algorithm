package dfs_bfs;

import java.util.*;

public class GridPathPruningBFS {
    static int[][] map = { // 각 위치의 이동 비용을 담고 있는 2차원 배열 (n: 맵 크기)
            {1, 3, 1},
            {2, 1, 2},
            {4, 3, 1}
    };
    static int n = 3;
    static int[][] dist; // 각 위치까지 도달하는 최소 비용을 저장하는 배열

    // 방향 벡터: 상하좌우 ((x+dx[i], y+dy[i]))
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // 상태 표현 클래스
    static class Point {
        int x, y, cost; // (x, y) 좌표, 그 위치까지의 누적 비용
        Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        // 초기화
        dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        // 실행
        bfs();
        System.out.println("🔚 최종 최소 비용: " + dist[n-1][n-1]); // 도착 지점 (n-1, n-1) 의 최소 비용 출력
    }

    static void bfs() {
        // 시작 지점 (0, 0) 자기 자신의 비용으로 초기화하며, 큐에 넣어 BFS 시작
        Queue<Point> q = new LinkedList<>();
        dist[0][0] = map[0][0];
        q.add(new Point(0, 0, map[0][0]));

        // 큐가 빌 때까지 반복한다.
        while (!q.isEmpty()) {
            Point p = q.poll();
            System.out.printf("📌 탐색 중: (%d,%d), 누적 비용: %d\n", p.x, p.y, p.cost); // 상하좌우 탐색

            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                // * 프루닝 핵심 로직 *
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int newCost = p.cost + map[nx][ny];

                    // newCost 가 현재 저장된 dist[nx][ny] 보다 작을 때만 갱신
                    if (newCost < dist[nx][ny]) {
                        System.out.printf("🔄 갱신: (%d,%d) 기존 %d → 새로운 비용 %d\n", nx, ny, dist[nx][ny], newCost);
                        dist[nx][ny] = newCost;
                        q.add(new Point(nx, ny, newCost)); // 더 나은 비용으로 도달할 수 있을 때만 큐에 추가
                    }
                }
            }
        }
    }
}
