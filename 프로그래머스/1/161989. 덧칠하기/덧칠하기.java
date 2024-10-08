class Solution {
    public int solution(int n, int m, int[] section) {
        
        int cur = 0, answer = 0;
        for (int i = 0; i < section.length; i++) {
            if (section[i] > cur) {
                cur = section[i] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}