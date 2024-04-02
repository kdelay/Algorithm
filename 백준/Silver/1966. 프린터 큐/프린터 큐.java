import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int testCase = Integer.parseInt(br.readLine());

    while (testCase-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken()); // 문서의 개수
      int M = Integer.parseInt(st.nextToken()); // queue 순서 중 궁금한 인쇄 번호 인덱스

      LinkedList<int[]> q = new LinkedList<>(); // queue로 이용할 연결리스트
      st = new StringTokenizer(br.readLine());

      for (int i=0; i<N; i++) q.offer(new int[] { i, Integer.parseInt(st.nextToken()) }); // {문서 위치, 중요도} 초기화

      int count = 0; // 출력 횟수

      while (!q.isEmpty()) { // q가 다 처리될 때까지 진행
        int[] front = q.poll(); // 첫번째 원소
        boolean isMax = true; // front가 가장 큰 원소인지 판단하는 변수

        // queue 내에 값들과 비교
        for (int i=0; i<q.size(); i++) {
          // 첫번째 원소보다 queue의 i번째에 있는 값이 클 경우
          if (front[1] < q.get(i)[1]) {
            // 첫번째 원소 + i 이전의 원소들을 모두 뒤로 보낸다.
            q.offer(front);
            for(int j=0; j<i; j++) q.offer(q.poll());

            // front가 가장 큰 원소가 아니었으므로 false하고 탐색을 마침
            isMax = false;
            break;
          }
        }
        // front가 가장 큰 원소가 아니었으므로 다음 반복문으로 넘어감
        if (isMax == false) continue;
        // front가 가장 큰 원소였으므로 해당 원소 출력해야함
        count++;
        if (front[0] == M) break; // 찾고자 한 문서면 테스트케이스 종료
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }
}
