import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 사람 수
    String[] input = br.readLine().split(" "); // 입력 값(인출 소요 시간)
    List<Integer> list = new ArrayList<>(); // 인출 소요 시간

    for (int i=0; i<N; i++) list.add(Integer.parseInt(input[i]));
    Collections.sort(list);

    int sum = 0;
    for (int i=0; i<list.size(); i++) {
      sum += list.get(i);
      list.set(i, sum);
    }
    int result = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    System.out.println(result);
  }
}