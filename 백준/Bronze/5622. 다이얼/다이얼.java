import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] input = sc.nextLine().toCharArray();
    Map<Character, Integer> map = new HashMap<>();

    int count = 0, data = 3;
    for (int i=65; i<=90; i++) {
      map.put((char)i, data);
      count++;
      if (i == 83) { // S인 경우
        map.replace((char)i, 8);
        count = 0;
      }
      if (i == 90) { // Z인 경우
        map.replace((char)i, 10);
      }
      if (count == 3) { count = 0; data++; }
    }

    int sum = 0;
    for (int i=0; i<input.length; i++) {
      sum += map.get(input[i]);
    }
    System.out.println(sum);
  }
}