import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] arr = new String[20];
    String[] gradeList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
    double[] scoreList = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
    double score = 0, sum = 0;

    for (int i = 0; i < 20; i++) {
      arr[i] = br.readLine();
      StringTokenizer st = new StringTokenizer(arr[i], " ");
      String a = st.nextToken(); // 과목명
      double b = Double.parseDouble(st.nextToken()); // 성적
      String c = st.nextToken(); // 학점

      for (int j = 0; j < 10; j++) {
        if (c.equals(gradeList[j])) { // 학점이 동일할 경우
          // scoreList에 있는 값으로 (학점 * 과목평점) 구하기
          score += (b * scoreList[j]);
          if (j != 9) { // 학점이 F/P가 아닌 경우만 더해서 (학점의 총합) 구하기
            sum += b;
          }
        }
      }
    }
    double average = (score / sum);
    System.out.printf("%.6f", average);
  }
}