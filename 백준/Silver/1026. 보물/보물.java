import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] a = new int[N];
    int[] b = new int[N];

    // 초기값
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }
    List<Integer> list = new ArrayList<>();
    for (int i=0; i<b.length; i++) {
      list.add(b[i]);
    }

    // 그리디 알고리즘을 위한 a 정렬
    Arrays.sort(a);

    int answer = 0;
    for (int i=0; i<a.length; i++) {
      int max = Collections.max(list); // max 값을 택함
      answer += (a[i] * max);
      // 사용한 max 값은 제거 (remove(Object o))
      list.remove(Integer.valueOf(max)); // Integer.valueOf는 Integer 객체를 반환한다.
    }
    System.out.println(answer);
  }
}