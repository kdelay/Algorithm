import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]); // 듣지 못한 사람의 수
    int M = Integer.parseInt(input[1]); // 보지 못한 사람의 수

    Map<String, Integer> map = new HashMap();
    for (int i=0; i<N; i++) map.put(br.readLine(), 1);

    for (int i=0; i<M; i++) {
      String name = br.readLine();
      // 듣보잡인 경우 value값을 2로 변경한다.
      if (map.containsKey(name)) map.replace(name, 2);
    }

    List<String> keySet = new ArrayList<>(map.keySet());
    // key 사전순 정렬
    Collections.sort(keySet);

    int count = 0;
    for (String k : keySet) {
      if (map.get(k) == 2) {
        count++;
        sb.append(k).append("\n");
      }
    }
    System.out.println(count + "\n" + sb);
  }
}
