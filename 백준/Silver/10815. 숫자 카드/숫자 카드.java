import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    Map<String, Integer> map = new HashMap<>();

    int N = Integer.parseInt(br.readLine());
    String[] a = br.readLine().split(" "); // 입력값
    for (int i=0; i<a.length; i++) {
      map.put(a[i], 1);
    }

    int M = Integer.parseInt(br.readLine());
    String[] b = br.readLine().split(" "); // 입력값
    for (int i=0; i<b.length; i++) {
      if (map.containsKey(b[i])) {
        sb.append(map.get(b[i])).append(" ");
      } else {
        sb.append(0).append(" ");
      }
    }
    System.out.println(sb);
  }
}