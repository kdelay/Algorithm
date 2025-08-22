class Solution {
    public int[] solution(int brown, int yellow) {
        int x, y = 0;
        int 가능한조합의합 = (brown + 4) / 2;
        int[] answer = new int[2];
        for (int i = 1; i<=가능한조합의합; i++){
            x = i; 
            y = 가능한조합의합 -x; 
            if(x < y) continue;
            if((x-2) * (y-2) == yellow){
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}