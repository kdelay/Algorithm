import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    //현재 위치, 양의 수, 늑대 수, 방문 노드 저장 클래스
    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    //트리 정보를 저장할 인접 리스트
    private static ArrayList<Integer>[] tree;

    //트리 구축 메서드
    private static void buildTree(int[] info, int[][] edges) {
        //트리 초기화
        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    /**
     * @param info 노드 정보(양/늑대)
     * @param edges 노드 연결 관계
     * @return 최대 양의 수
     */
    public static int solution(int[] info, int[][] edges) {
        buildTree(info, edges); //트리 생성
        int answer = 0; //최대 양의 수를 저장할 변수

        //BFS를 위한 큐 생성 및 초기 상태 설정
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>())); //루트 노드

        //BFS
        while (!queue.isEmpty()) {
            //큐에서 현재 상태를 꺼냄
            Info now = queue.poll();
            //최대 양의 수 업데이트
            answer = Math.max(answer, now.sheep);
            //방문한 노드 집합에 현재 노드의 이웃 노드 추가
            now.visited.addAll(tree[now.node]);

            //인접한 노드들에 대해 탐색
            for (int next : now.visited) {
                //기존 해시셋의 데이터를 복사하고 현재 방문한 정점을 해시셋에서 제거 -> 방문한 노드를 다시 방문하지 않도록 할 수 있다.
                //인접 노드만 추가할 수 있다. (1인 경우 8 추가됨.)
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                if (info[next] == 1) { //늑대일 경우
                    if (now.sheep != now.wolf + 1) { //늑대의 수가 양보다 같거나 많아지지 않는 경우
                        queue.add(new Info(next, now.sheep, now.wolf+1, set));
                    }
                } else { //양일 경우
                    queue.add(new Info(next, now.sheep+1, now.wolf, set));
                }
            }
        }
        return answer;
    }
}