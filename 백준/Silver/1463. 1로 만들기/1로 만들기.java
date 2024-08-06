import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        System.out.println(dp(0, x));
    }

    private static int dp(int cnt, long x) {
        //재귀 종료 조건
        if (x < 2) return cnt;

        //2와 3으로 나누어지지 않는 경우, 1을 빼야 하기 때문에 % 모듈러 연산 개수 추가
        //3으로 나눌 경우: 10(1) -> 3 -> 1 (cnt:2) + x%3 (cnt:1) = cnt:3
        //2로 나눌 경우: 10 -> 5(1) -> 2 -> 1 (cnt:3) + x%2 (cnt:1) = cnt:4
        return Math.min(dp((int)(cnt+1+(x%3)), x/3), dp((int)(cnt+1+(x%2)), x/2));
    }
}
