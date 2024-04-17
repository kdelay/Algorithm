import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = 0;
    for (int i=0; i<N; i++) {
      if (check(br.readLine())) count++;
    }
    System.out.println(count);
  }
  static boolean check(String input) {
    boolean result = false;
    boolean[] abc = new boolean[26];
    for (int i=0; i<input.length(); i++) {
      // 다른 값인데 이미 true로 설정되어 있는 경우
      if (i > 0 && ( input.charAt(i) != input.charAt(i-1) && abc[input.charAt(i) - 97] )) {
        return false;
      } else result = true;
      abc[input.charAt(i)-97] = true;
    }
    return result;
  }
}