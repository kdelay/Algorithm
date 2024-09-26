import java.util.*;

class Solution {
    public String solution(int a, int b) {
        
        //요일
        String[] weekday = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        //각 월별 시작 요일
        int[] start = new int[]{5, 1, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        
        return weekday[(start[a - 1] + (b - 1)) % 7];
    }
}