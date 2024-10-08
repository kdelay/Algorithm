import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        return IntStream.range(0, num_list.length)
            .map(i -> num_list[num_list.length - 1 - i]) //역순 매핑
            .toArray();
    }
}