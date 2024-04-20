import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    boolean[][] arr = new boolean[100][100];

    int area = 0;
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      for (int j=a; j<a+10; j++) {
        for (int k=b; k<b+10; k++) {
          // 비어있는 공간에 색종이 영역 추가(중복 방지)
          if (!arr[j][k]) {
            arr[j][k] = true;
            area++;  
          }
        }
      }
    }
    System.out.println(area);
  }
}