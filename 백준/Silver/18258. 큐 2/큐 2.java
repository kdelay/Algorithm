import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<N; i++) {
      String[] input = br.readLine().split(" ");
      switch (input[0]) {
        case "push":
          deque.addLast(Integer.parseInt(input[1]));
          break;
        case "pop":
          if (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append("\n");
          } else {
            sb.append(-1).append("\n");
          }
          break;
        case "size":
          sb.append(deque.size()).append("\n");
          break;
        case "empty":
          if (deque.isEmpty()) sb.append(1).append("\n");
          else sb.append(0).append("\n");
          break;
        case "front":
          if (deque.isEmpty()) sb.append(-1).append("\n");
          else sb.append(deque.getFirst()).append("\n");
          break;
        case "back":
          if (deque.isEmpty()) sb.append(-1).append("\n");
          else sb.append(deque.getLast()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }
}