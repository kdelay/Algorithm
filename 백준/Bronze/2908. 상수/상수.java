import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    N = (N / 100) + (((N % 100) / 10) * 10) + (((N % 100) % 10) * 100);
    M = (M / 100) + (((M % 100) / 10) * 10) + (((M % 100) % 10) * 100);
    System.out.println(Math.max(N, M));
  }
}