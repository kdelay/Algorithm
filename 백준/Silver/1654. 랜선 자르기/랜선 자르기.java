import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken()); // 랜선의 개수
    int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
    int[] lans = new int[K];

    long max = 0;

    for (int i=0; i<K; i++) {
      lans[i] = Integer.parseInt(br.readLine()); // 초기값 세팅
      if (max < lans[i]) max = lans[i]; // 최댓값 갱신
    }

    // 최댓값은 {1,1}인 경우를 위해 +1를 한다.
    max++;

    long min = 0; // 최솟값 정의
    long mid = 0; // 중간값 정의

    while (min < max) {
      mid = (min + max) / 2; // 범위 내 중간값
      long count = 0; // 랜선 개수

      for (int i=0; i< lans.length; i++) {
        count += (lans[i] / mid); // 만들 수 있는 랜선 개수
      }

      if (count < N) max = mid; // 필요한 랜선 개수보다 적으면 (min ~ mid)중에서 다시 이분 탐색을 한다.
      else min = mid + 1; // 필요한 랜선 개수보다 동일하거나 많으면 (mid+1 ~ max) 중에서 다시 이분 탐색을 한다.
    } // min이 max보다 큰 값으로 루프 종료

    System.out.println(min - 1); // 최종 값
  }
}
