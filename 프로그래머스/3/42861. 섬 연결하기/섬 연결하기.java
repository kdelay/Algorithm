import java.util.*;


//핵심 키포인트: 정렬, 집합, 사이클, 비용
class Solution {
    
    private static int[] nodes;
    
    public int solution(int n, int[][] costs) {
        
        //비용이 낮은 순으로 오름차순 정렬
        Arrays.sort(costs, Comparator
                   .comparingInt((int[] o) -> o[2])
                   .thenComparingInt(o -> o[1])
                   .thenComparingInt(o -> o[0]));
        
        //집합 초기화
        nodes = new int[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
        
        int edge = 0; //간선 개수
        int result = 0; //최소 비용
        for (int[] node : costs) {
            
            //사이클이 있으면 안되므로 간선의 개수는 n-1 개여야 한다.
            if (edge == n-1) break;
            
            //연결되어 있지 않은 노드 union
            if (find(node[0]) != find(node[1])) {
                union(node[0], node[1]);
                result += node[2]; //비용 추가
                edge++; //간선 추가
            }
        }
        return result;
    }
    
        private static int find(int x) {
        //자신이 루트 노드일 경우 반환
        if (nodes[x] == x) return x;
        //루트 노드 찾기
        return find(nodes[x]);
    }

    private static void union(int x, int y) {
        //x가 속한 집합의 루트 노드 찾기
        int rootX = find(x);
        //y가 속한 집합의 루트 노드 찾기
        int rootY = find(y);
        //작은 노드를 루트 노드로 연결
        nodes[rootY] = rootX;
    }
}