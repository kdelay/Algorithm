import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[N];

    for (int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
    Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

    int max = 0;
    for (int i=0; i<arr.length; i++) max = Math.max(max, arr[i] * (i+1)); // 가능한 중량 저장
    System.out.println(max);
  }
}