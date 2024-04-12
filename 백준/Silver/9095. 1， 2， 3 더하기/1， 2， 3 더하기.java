import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    // 경우의 수 배열 값 지정
    int[] arr = new int[12];
    // 1, 2, 3의 방법 수 기본 값을 세팅한다.
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    // 4~11까지 값 세팅
    for (int j=4; j<arr.length; j++) arr[j] = arr[j-3] + arr[j-2] + arr[j-1];

    // 입력 값 경우의 수 찾기
    for (int i=0; i<testCase; i++) {
      int N = Integer.parseInt(br.readLine());
      System.out.println(arr[N]);
    }
  }
}