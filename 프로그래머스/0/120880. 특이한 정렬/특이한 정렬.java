import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] numlist, int n) {
                Comparator<Integer> comparator = (a, b) -> {
            int ca = Math.abs(a - n);
            int cb = Math.abs(b - n);
            if (ca != cb) { //거리가 동일하지 않은 경우, 거리에 대해서 오름차순 정렬
                return Integer.compare(ca, cb);
            } else { //거리가 동일한 경우, 값에 대해서 내림차순 정렬
                return Integer.compare(b, a);
            }
        };
        
        //Integer 배열로 변환
        Integer[] list = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        //comparator를 이용해서 정렬
        Arrays.sort(list, comparator);
        //int 배열로 변환
        numlist = Arrays.stream(list).mapToInt(Integer::intValue).toArray();
        return numlist;
    }
}