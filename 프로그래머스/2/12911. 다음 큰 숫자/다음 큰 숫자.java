class Solution {
    public int solution(int n) {
        
        String str = Integer.toBinaryString(n);
        int strOne = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') strOne++;
        }
        
        int nextOne = 0, tmp = n+1;
        String t = Integer.toBinaryString(tmp);
        
        while (true) {
            for (char c : t.toCharArray()) if (c == '1') nextOne++;
            if (strOne == nextOne) break;
            
            nextOne = 0; tmp++;
            t = Integer.toBinaryString(tmp);
        }
        return tmp;
    }
}