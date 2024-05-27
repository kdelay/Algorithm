import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Long> arr = new ArrayList<>();

        for (long i = left; i < right + 1; i++) {
            arr.add(Math.max(i/n, i%n) + 1);
        }

        return arr.stream().mapToInt(Long::intValue).toArray();
    }
}