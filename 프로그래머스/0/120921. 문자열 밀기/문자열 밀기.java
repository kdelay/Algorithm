class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) return 0;

        int len = A.length();
        String rotated = A;

        for (int i = 1; i < len; i++) {
            rotated = rotated.charAt(len - 1) + rotated.substring(0, len - 1);
            if (rotated.equals(B)) return i;
        }
        return -1;
    }
}