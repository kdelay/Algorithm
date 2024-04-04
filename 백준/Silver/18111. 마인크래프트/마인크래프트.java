import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][M];

    int max = 0;
    int min = 256;

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++) {
        int ground = Integer.parseInt(st.nextToken());
        arr[i][j] = ground; // 땅 높이 입력 받기
        if (ground > max) max = ground; // 최대 높이
        if (ground < min) min = ground; // 최소 높이
      }
    }

    int totalTime = Integer.MAX_VALUE, totalHeight = Integer.MIN_VALUE;

    for(int k=min; k<=max; k++) { // (min ~ max) 높이만큼 진행
      int time = 0; // 소요 시간
      int block = B; // 필요한 블럭 수

      for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
          if (k < arr[i][j]) { // 땅을 갈아야 하는 경우
            time += ((arr[i][j] - k) * 2); // 갈은 블럭 수 * 2초 소요
            block += (arr[i][j] - k); // 블럭 추가됨
          } else { // 땅을 보강해야 하는 경우
            time += (k - arr[i][j]); // 보강한 블럭 수만큼 시간 소요
            block -= (k - arr[i][j]); // 블럭 사용됨
          }
        }
      }
      if (block < 0) break; // block은 인벤토리에 있는 만큼만 사용 가능

      if (time <= totalTime) {
        totalTime = time; // 총 시간이 짧게 걸렸다면 값 변경
        if (k > totalHeight) totalHeight = k; // 땅의 높이가 가장 높은 것을 출력해야 한다.
      }
    }
    System.out.println(totalTime + " " + totalHeight);
  }
}
