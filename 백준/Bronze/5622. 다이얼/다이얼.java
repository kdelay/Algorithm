import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    int time = 0;

    for (int i=0; i<input.length(); i++) {
      if (input.charAt(i) < 'D') time += 3;
      else if (input.charAt(i) < 'G') time += 4;
      else if (input.charAt(i) < 'J') time += 5;
      else if (input.charAt(i) < 'M') time += 6;
      else if (input.charAt(i) < 'P') time += 7;
      else if (input.charAt(i) < 'T') time += 8;
      else if (input.charAt(i) < 'W') time += 9;
      else if (input.charAt(i) <= 'Z') time += 10;
    }
    System.out.println(time);
  }
}