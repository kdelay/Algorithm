import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//--- Union-Find Algorithm
public class Solution {

    //{0,1,2} -> 노드 1과 2에 대해 union 연산
    //{1,1,3} -> 노드 1과 3이 같은 집합에 속해 있으면 true, 아니면 false 를 반환하는 equals 연산

    //0 -> union, 1 -> equals 연산

    static int[] nodes;

    public static void main(String[] args) {
        int k = 3;
        int[][] operations = {{0,0,1}, {0,1,2}, {1,1,2}};
//        int[][] operations = {{0,0,1},{1,1,2},{0,1,2},{1,0,2}};

        //초기 노드
        nodes = new int[k];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }

        List<Boolean> result = Arrays.stream(operations)
                .map(op -> solution(op[0], op[1], op[2]))
                .filter(Objects::nonNull)
                .toList();
        System.out.println(result);
    }

    public static Boolean solution(int node, int x, int y) {
        switch (node) {
            case 0:
                union(x, y);
                return null;
            case 1:
                return equals(x, y);
        }
        return null;
    }

    private static void union(int x, int y) {
        if (x < y) nodes[x] = y;
        else nodes[y] = x;
    }

    private static boolean equals(int x, int y) {
        //종료 조건
        if (nodes[x] == y) return true; //부모 노드일 경우 같은 집합
        if (x == nodes[x]) return false; //루트 노드일 경우 다른 집합

        //루트 노드까지 재귀 진행
        return equals(nodes[x], y);
    }
}
