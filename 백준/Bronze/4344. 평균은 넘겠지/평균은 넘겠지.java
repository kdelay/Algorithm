import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    ArrayList<Integer> list;
    int T = Integer.parseInt(br.readLine());

    for (int i=0; i<T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      list = new ArrayList<>();

      // 학생 점수 입력
      int sum = 0;
      for (int j=0; j<N; j++) {
        int a = Integer.parseInt(st.nextToken());
        sum += a;
        list.add(a);
      }
      int average = sum / N;

      // 평균을 넘는 학생 수 구하기
      int count = 0;
      for (int j=0; j<N; j++) {
        if (list.get(j) > average) count++;
      }

      // 비율
      String result = String.format( "%.3f", (count * 100f) / N );
      System.out.println(result+"%");
    }
  }
}