class Solution {
    public long solution(long n) {
        int[] nn = new int[10];
        String[] s = Long.toString(n).split("");
        for (String string : s) {
            nn[Integer.parseInt(string)]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (nn[i] > 0) {
                sb.append(i);
                nn[i]--;
            }
        }
        return Long.parseLong(sb.toString());
    }
}