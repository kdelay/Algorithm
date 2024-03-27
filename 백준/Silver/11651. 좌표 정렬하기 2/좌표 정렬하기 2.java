import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] point = new int[N][2];
    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      point[i][0] = Integer.parseInt(input[0]);
      point[i][1] = Integer.parseInt(input[1]);
    }

    Arrays.sort(point, (a, b) -> a[1] != b[1] ? a[1]-b[1] : a[0]-b[0]);
    for (int i=0; i<N; i++) System.out.println(point[i][0] + " " + point[i][1]);
  }
}
