import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long a, long exponent) {
        //지수가 1인 경우 a값 그대로 리턴
        if (exponent == 1) {
            return a % C;
        }

        //지수 분할정복(재귀 진행)
        long temp = pow(a, exponent/2);

        //지수가 홀수인 경우
        if (exponent % 2 == 1) {
            return ((temp * temp % C) * a) % C;
        }

        //지수가 짝수인 경우
        return temp * temp % C;
    }

}