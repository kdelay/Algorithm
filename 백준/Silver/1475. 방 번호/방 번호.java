import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] N = br.readLine().toCharArray();
    int[] visited = new int[10]; // 방문 노드

    for (int i=0; i<N.length; i++){
      int a = N[i] - '0';
      if (a == 9) a = 6; // 9인 경우 6으로 세팅해서 동일한 인덱스로 설정
      visited[a]++;
    }
    visited[6] = visited[6]/2 + visited[6]%2; // 두 번 더해진 횟수를 2로 나누기
    Arrays.sort(visited); // 오름차순 정렬
    System.out.println(visited[9]); // Max 값 : 카드 set 개수
  }
}