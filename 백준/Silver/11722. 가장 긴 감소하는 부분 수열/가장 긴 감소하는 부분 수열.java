import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aLen = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[aLen];
        for (int i = 0; i < aLen; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[aLen];
        Arrays.fill(dp, 1);
        for (int i = 1; i < aLen; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int answer = 0;
        for (int d : dp) {
            answer = Math.max(answer, d);
        }
        System.out.println(answer);
    }
}