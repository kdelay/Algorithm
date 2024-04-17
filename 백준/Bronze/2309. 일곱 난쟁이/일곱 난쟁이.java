import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    int[] arr = new int[9];
    for (int i=0; i<9; i++) {
      int a = Integer.parseInt(br.readLine());
      arr[i] = a;
      sum += a;
    }
    Arrays.sort(arr); // 오름차순 정렬

    int r = sum - 100;
    int index1 = 0, index2 = 0;
    for (int i=0; i<arr.length-1; i++) {
      for (int j=i+1; j<arr.length; j++) {
        if (arr[i] + arr[j] == r) { // 범인
          index1 = i;
          index2 = j;
          break;
        }
      }
    }

    for (int i=0; i<arr.length; i++) {
      if (i != index1 && i != index2) System.out.println(arr[i]);
    }
  }
}