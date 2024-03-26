import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] rank = new int[N];
    Arrays.fill(rank, 1);
    int[][] people = new int[N][N];

    for (int i=0; i<N; i++) {
      String[] input = br.readLine().split(" ");
      people[i][0] =  Integer.parseInt(input[0]);
      people[i][1] =  Integer.parseInt(input[1]);
    }

    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        if (people[i][0] < people[j][0] && people[i][1] < people[j][1])
          rank[i]++; // 등수 밀려남
      }
    }
    for (int r : rank) System.out.print(r + " ");
  }
}
