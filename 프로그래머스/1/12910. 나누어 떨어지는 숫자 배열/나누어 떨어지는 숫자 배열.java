import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (j % divisor == 0) {
                list.add(j);
            }
        }

        if (list.isEmpty()) list.add(-1);
        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}