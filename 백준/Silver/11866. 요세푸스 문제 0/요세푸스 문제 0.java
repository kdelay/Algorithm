import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        josephusPermutation(N, K);
        System.out.println(sb);
    }

    public static void josephusPermutation(int n, int k) {
        Queue<Integer> arr = new LinkedList<>();
        for (int i=1; i<=n; i++) arr.add(i); // 초기 값 세팅
        sb.append("<");

        while (!arr.isEmpty()) {
            if (n == 1 && k == 1 || arr.size() == 1) {
                sb.append(arr.remove()).append(">");
                return;
            } else {
                for (int i = 1; i <= k; i++) {
                    int a = 0;
                    if (i == k) sb.append(arr.remove()).append(", ");
                    else {
                        a = arr.remove();
                        arr.add(a);
                    }
                }
            }
        }
    }
}