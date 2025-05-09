class Solution {
    private static boolean[] visited;
    private static int[][] computer;
    
    public int solution(int n, int[][] computers) {
        int count = 0;
        visited = new boolean[n];
        computer = computers;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
    
    private static void dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < computer[node].length; i++) {
            if (!visited[i] && computer[node][i] == 1) {
                dfs(i);    
            }
        }
    }
}