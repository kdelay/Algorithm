import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int M = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      String operator = st.nextToken();

      switch (operator) {
        case "add":
          set.add(Integer.parseInt(st.nextToken()));
          break;
        case "remove":
          if (!set.isEmpty()) set.remove(Integer.parseInt(st.nextToken()));
          break;
        case "check":
          if (set.contains(Integer.parseInt(st.nextToken()))) sb.append("1").append("\n");
          else sb.append("0").append("\n");
          break;
        case "toggle":
          int num = Integer.parseInt(st.nextToken());
          if (set.contains(num)) set.remove(num);
          else set.add(num);
          break;
        case "all":
          set.clear();
          for (int j=1; j<=20; j++) set.add(j);
          break;
        case "empty":
          set.clear();
          break;
      }
    }
    System.out.println(sb);
  }
}
