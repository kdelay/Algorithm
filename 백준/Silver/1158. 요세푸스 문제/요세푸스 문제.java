import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    sb.append("<");

    for (int i=1; i<=N; i++) queue.add(i); // 1 ~ N까지의 수 저장
    while (true) {
      if (queue.size() == 1) { // queue가 1개 남은 경우
        sb.append(queue.poll()).append(">");
        break;
      }
      int cnt = 1;
      while (true) {
        if (cnt == K) { // K번째인 경우 제거되는 순서 값 저장
          sb.append(queue.poll()).append(", ");
          break;
        } else { // K번 만큼 요세푸스 순열 동작
          cnt++;
          queue.add(queue.poll());
        }
      }
    }
    System.out.println(sb);
  }
}