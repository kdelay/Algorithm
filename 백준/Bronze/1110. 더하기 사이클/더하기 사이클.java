import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 입력 값
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int result = N;
    int count = 0;

    while (true) {
      N = ( (N % 10) * 10 ) + ( ((N / 10) + (N % 10)) % 10 );
      count++;
      if (N == result) break;
    }
    System.out.println(count);
  }
}