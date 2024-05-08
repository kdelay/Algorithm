import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            dp[i] = 1;

            for (int j=0; j<i; j++) {
                //우측 값이 더 크고, 연장 가능한 수열일 경우 dp 내 값 증가
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        //최대 길이 탐색
        int max = -1;
        for (int i=0; i<N; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}