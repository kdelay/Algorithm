import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> name = new HashMap<>();
        Map<Integer, int[]> share = new HashMap<>();
        
        //초기 데이터
        int idx = 0;
        for (String friend : friends) {
            name.put(friend, idx++);
            share.put(name.get(friend), new int[]{0, 0});
        }
        
        int[][] count = new int[name.size()][name.size()];
        boolean[][] visited = new boolean[name.size()][name.size()];
        for (String gift : gifts) {
            int give = name.get(gift.split(" ")[0]);
            int take = name.get(gift.split(" ")[1]);
            
            //주고 받은 선물 개수(선물 지수 계산에 사용)
            share.get(give)[0]++;
            share.get(take)[1]++;
            
            //누구한테 선물 받았는지
            count[give][take]++;
        }
        
        //선물 지수 계산
        Map<Integer, Integer> state = new HashMap<>();
        for (String n : name.keySet()) {
            int value = share.get(name.get(n))[0] - share.get(name.get(n))[1];
            state.put(name.get(n), value);
        }
        
        int[] result = new int[name.size()];
        for (int i = 0; i < name.size(); i++) {
            for (int j = 0; j < name.size(); j++) {
                if (i == j) continue;
                
                if (!visited[i][j] && !visited[j][i]) {
                    if (count[i][j] > count[j][i]) result[i]++;
                    else if (count[i][j] < count[j][i]) result[j]++;
                    //동일한 경우 선물 지수 비교
                    else {
                        if (state.get(i) > state.get(j)) result[i]++;
                        else if (state.get(i) < state.get(j)) result[j]++;
                    }    
                }
                visited[i][j] = true; visited[j][i] = true;
            }
        }
        int answer = 0;        
        for (int r : result) {
            answer = Math.max(answer, r);
        }
        return answer;
    }
}