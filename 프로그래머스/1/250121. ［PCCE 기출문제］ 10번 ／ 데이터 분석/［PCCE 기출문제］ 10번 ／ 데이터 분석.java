import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int filterIndex = getIndex(ext);
        int sortedIndex = getIndex(sort_by);

        List<int[]> list = Arrays.stream(data)
            .filter(d -> d[filterIndex] < val_ext) //val_ext 보다 작은 데이터 필터
            .sorted(Comparator.comparingInt(d -> d[sortedIndex])) //오름차순 정렬
            .collect(Collectors.toList());
        
        return list.stream()
            .toArray(int[][]::new);
    }
    
    private int getIndex(String title) {
        switch (title) { 
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                return -1;
        }
    }
}
