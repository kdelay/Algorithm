import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> name = new HashMap<>();
        
        //초기 데이터
        for (int i = 0; i < friends.length; i++) {
            name.put(friends[i], i);
        }
        
        int[] share = new int[friends.length];
        int[][] count = new int[friends.length][friends.length];
        
        for (String gift : gifts) {
            int give = name.get(gift.split(" ")[0]);
            int take = name.get(gift.split(" ")[1]);
            
            //선물 지수 계산
            share[give]++;
            share[take]--;
            
            //누구한테 선물 받았는지
            count[give][take]++;
        }
        
        int answer = 0;
        for (int i = 0; i < name.size(); i++) {
            int tmp = 0; //인당 얼마나 선물을 받았는지 계산 변수
            for (int j = 0; j < name.size(); j++) {
                if (i == j) continue;
                
                if (count[i][j] > count[j][i]) tmp++;
                //동일한 경우 선물 지수 비교
                else if (count[i][j] == count[j][i] && share[i] > share[j]) tmp++;
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}