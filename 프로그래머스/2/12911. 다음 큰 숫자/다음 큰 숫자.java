class Solution {
    public int solution(int n) {
        
        int strOne = Integer.bitCount(n);
        int tmp = n+1;
        int nextOne = Integer.bitCount(tmp);
        
        while (strOne != nextOne) {
            tmp++;
            nextOne = Integer.bitCount(tmp);
        }
        return tmp;
    }
}