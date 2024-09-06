class Solution {
    public int solution(int[] sides) {
        
        int min = Math.min(sides[0], sides[1]);
        int max = Math.max(sides[0], sides[1]);
        
        int x = 1, answer = 0;
        //max 가 가장 긴 변인 경우
        while (x <= max) {
            if (min + x > max) answer++;
            x++;
        }
        
        //나머지 한 변이 가장 긴 변인 경우
        while (min + max > x) {
            if (x > max) answer++;
            x++;
        }
        return answer;
    }
}