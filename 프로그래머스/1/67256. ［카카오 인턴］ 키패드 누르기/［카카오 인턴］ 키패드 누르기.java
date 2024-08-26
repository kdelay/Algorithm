import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {

        Map<Integer, int[]> keys = new HashMap<>();
        keys.put(1, new int[]{0, 0});
        keys.put(2, new int[]{0, 1});
        keys.put(3, new int[]{0, 2});
        keys.put(4, new int[]{1, 0});
        keys.put(5, new int[]{1, 1});
        keys.put(6, new int[]{1, 2});
        keys.put(7, new int[]{2, 0});
        keys.put(8, new int[]{2, 1});
        keys.put(9, new int[]{2, 2});
        keys.put(10, new int[]{3, 0}); //'*'을 10로 표현
        keys.put(11, new int[]{3, 1});
        keys.put(12, new int[]{3, 2}); //'#'을 12로 표현

        StringBuilder sb = new StringBuilder();

        //초기 위치
        int left = 10;
        int right = 12;

        for (int n : numbers) {
            if (n == 0) n = 11;
            int num = (n % 3);
            switch (num) {
                case 0:
                    sb.append("R");
                    right = n;
                    break;
                case 1:
                    sb.append("L");
                    left = n;
                    break;
                case 2:
                    int x = keys.get(n)[0];
                    int y = keys.get(n)[1];

                    int l = Math.abs(x - keys.get(left)[0]) + Math.abs(y - keys.get(left)[1]);
                    int r = Math.abs(x - keys.get(right)[0]) + Math.abs(y - keys.get(right)[1]);

                    if (l < r) {
                        sb.append("L");
                        left = n;
                    }
                    else if (r < l) {
                        sb.append("R");
                        right = n;
                    }
                    else {
                        if (hand.equals("right")) { sb.append("R"); right = n; }
                        else { sb.append("L"); left = n; }
                    }
                    break;
            }
        }
        return sb.toString();
    }
}