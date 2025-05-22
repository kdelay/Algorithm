import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//--- Union-Find Algorithm
public class UnionFind {

    //{0,1,2} -> 노드 1과 2에 대해 union 연산
    //{1,1,3} -> 노드 1과 3이 같은 집합에 속해 있으면 true, 아니면 false 를 반환하는 equals 연산

    //0 -> union, 1 -> equals 연산

    private static int[] nodes;

    public static void main(String[] args) {
        int k = 4;
//        int[][] operations = {{0,0,1}, {0,1,2}, {1,1,2}};
        int[][] operations = {{0,0,1},{1,1,2},{0,1,2},{1,0,2}};
        System.out.println(Arrays.toString(solution(k, operations)));
    }

    public static Boolean[] solution(int k, int[][] operations) {
        //초기 노드
        nodes = new int[k];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] operation : operations) {
            int op = operation[0];
            int x = operation[1], y = operation[2];

            if (op == 0) union(x, y);
            else result.add(find(x) == find(y));
        }
        return result.toArray(new Boolean[0]);
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
