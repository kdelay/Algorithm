# DP (Dynamic Programming)
- 동적 계획법
- `memorizing` 기법을 추가로 사용하면 시간 효율성이 높아진다.

<details>
  
  <summary>쉬운 계단 수</summary>

  [쉬운 계단 수](https://github.com/kdelay/Algorithm/commit/ffcb52cfa03908dee334e2170fa54148af872909) 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    final static long mod = 1_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10]; //[자릿수][자릿값(0~9)]

        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        //Bottom-Up DP
        for (int i=2; i<=N; i++) {
            for (int j=0; j<10; j++) {
                //0인 경우는 1만 올 수 있다.
                if (j == 0) {
                    dp[i][0] = dp[i-1][1] % mod;
                }
                //9인 경우는 8만 올 수 있다.
                else if (j == 9) {
                    dp[i][9] = dp[i-1][8] % mod;
                }
                //그 외는 -1/+1 값이 올 수 있다.
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }
        long result = 0;
        for (int i=1; i<10; i++) {
            result += dp[N][i];
        }
        System.out.println(result % mod);
    }
}
```

</details>
