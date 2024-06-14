import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    /**
     * @param clothes 의상 배열[의상의 이름, 의상의 종류]
     * @return 서로 다른 옷의 조합의 수
     */
   public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }
}