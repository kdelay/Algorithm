import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Integer> arr = new ArrayList<>();
    for (int i=0; i<N; i++) arr.add(Integer.parseInt(br.readLine()));
    Collections.sort(arr);

    int excludingNumber = (int) Math.round(N * 0.15);
    // 상위 15%, 하위 15%를 제외한 새로운 배열 생성
    List<Integer> newArr = arr.subList(excludingNumber, N - excludingNumber);
    int sum = 0, average = 0;

    for (int a : newArr) sum += a;
    average = (int) Math.round((double) sum / newArr.size());

    System.out.println(average);
  }
}
