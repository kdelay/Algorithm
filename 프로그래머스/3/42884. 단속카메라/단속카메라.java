import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        //진입 지점 기준 오름차순 정렬
        Arrays.sort(routes, (a,b) -> {
            return a[1] - b[1];
        });

        //나간 지점을 max 값으로 두고, 카메라 설치
        int max = routes[0][1];
        answer ++;
        
        for(int[] route : routes){
            //나간 지점보다 진입 지점이 더 큰 경우 새로운 카메라를 설치해야 한다.
            if(max < route[0]) {
                max = route[1];
                answer++;
            }
        }
        return answer;
    }
}