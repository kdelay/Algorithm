import java.util.*;

class Solution {
    public int solution(int n) {
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i*i <= n; i++) {
            //소수인 경우
            if (isPrime[i]) {
                //배수 모두 false로 변경
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) answer++;
        }
        return answer;
    }
}