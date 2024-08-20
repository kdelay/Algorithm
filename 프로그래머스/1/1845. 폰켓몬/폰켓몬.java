import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        int having = nums.length / 2;
        //가져갈 수 있는 폰켓몬 수보다 더 많은 종류를 가져갈 수 없다.
        if (set.size() > having) return having;
        return set.size();
    }
}