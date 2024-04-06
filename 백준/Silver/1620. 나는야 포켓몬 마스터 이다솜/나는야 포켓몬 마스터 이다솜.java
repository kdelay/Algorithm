import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // N : 포켓몬의 개수, M : 맞춰야 하는 문제 개수
    String[] string = br.readLine().split(" ");
    int N = Integer.parseInt(string[0]);
    int M = Integer.parseInt(string[1]);

    // 도감
    Map<String, Integer> mapKeyString = new HashMap<>(); // key : 포켓몬 이름
    Map<Integer, String> mapKeyInteger = new HashMap<>(); // key : 도감 번호

    // 도감 포켓몬 목록 받기
    for (int i=0; i<N; i++) {
      String dogam = br.readLine();
      mapKeyString.put(dogam, i+1);
      mapKeyInteger.put(i+1, dogam);
    }

    // 문제 맞추기
    for (int i=0; i<M; i++) {
      String input = br.readLine();
      // 입력 값이 숫자인지 확인
      boolean isNumberic = input.chars().allMatch(Character::isDigit);

      // 숫자인 경우 {1, "Bulbasaur"}
      if (isNumberic) {
        // key가 있으면 value 값 저장
        if (mapKeyInteger.containsKey(Integer.parseInt(input)))
          sb.append(mapKeyInteger.get(Integer.parseInt(input))).append("\n");
      } else { // 문자인 경우 {"Bulbasaur", 1}
        // key가 있으면 value 값 저장
        if (mapKeyString.containsKey(input))
          sb.append(mapKeyString.get(input)).append("\n");
      }
    }
    System.out.println(sb);
  }
}
