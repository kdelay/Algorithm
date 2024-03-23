import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i=0; i<N; i++) {
      String[] input = br.readLine().split(" ");
      switch (input[0]) {
        case "push_front":
          deque.addFirst(Integer.valueOf(input[1]));
          break;
        case "push_back":
          deque.addLast(Integer.valueOf(input[1]));
          break;
        case "pop_front":
          if (deque.isEmpty()) { System.out.println(-1); break; }
          System.out.println(deque.removeFirst());
          break;
        case "pop_back":
          if (deque.isEmpty()) { System.out.println(-1); break; }
          System.out.println(deque.removeLast());
          break;
        case "size":
          System.out.println(deque.size());
          break;
        case "empty":
          System.out.println(deque.isEmpty() ? 1 : 0);
          break;
        case "front":
          if (deque.isEmpty()) { System.out.println(-1); break; }
          System.out.println(deque.getFirst());
          break;
        case "back":
          if (deque.isEmpty()) { System.out.println(-1); break; }
          System.out.println(deque.getLast());
          break;
      }
    }
  }
}
