import java.util.*;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int filterIndex = -1;
        switch (ext) {
            case "code":
                filterIndex = 0; break;
            case "date":
                filterIndex = 1; break;
            case "maximum":
                filterIndex = 2; break;
            case "remain":
                filterIndex = 3; break;
        }

        int sortedIndex = -1;
        switch (sort_by) {
            case "code":
                sortedIndex = 0; break;
            case "date":
                sortedIndex = 1; break;
            case "maximum":
                sortedIndex = 2; break;
            case "remain":
                sortedIndex = 3; break;
        }

        List<int[]> list = new ArrayList<>();

        for (int[] d : data) {
            if (d[filterIndex] < val_ext) {
                list.add(d);
            }
        }

        int index = sortedIndex;
        list.sort((o1, o2) -> Integer.compare(o1[index], o2[index]));
        
        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}