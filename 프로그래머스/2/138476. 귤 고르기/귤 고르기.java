import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> busket = new HashMap<>();
        for (int t : tangerine) {
            busket.put(t, busket.getOrDefault(t, 0) + 1);
        }
        List<Integer> counts = new ArrayList<>(busket.values());
        counts.sort(Comparator.reverseOrder());
        for (int count : counts) {
            if (k <= 0) {
                break;
            }
            k -= count;
            answer++;
        }
        return answer;
    }
}