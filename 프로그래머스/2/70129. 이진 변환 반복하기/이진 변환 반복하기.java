class Solution {
    static int remove = 0;
    static int count = 0;
    
    public int[] solution(String s) {
        if (s.equals("1")) return new int[]{0, 0};
        toBinary(s);
        return new int[]{count, remove};
    }

    private void toBinary(String s) {
        if (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') remove++;
                else sb.append(c);
            }
            count++;
            toBinary(Integer.toBinaryString(sb.length()));
        }
    }
}