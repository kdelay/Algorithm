import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    int count = 0;
    for (int i=0; i<input.length(); i++) {
      char c = input.charAt(i);
      if (i == input.length() - 1) {
        count++;
        break;
      }
      if (i < input.length() - 1) {
        switch (c) {
          case 'c':
            // c= or c-
            if (input.charAt(i + 1) == '=' || input.charAt(i + 1) == '-') {
              i++;
              count++;
            } else count++;
            break;
          case 'd':
            // d-
            if (input.charAt(i + 1) == '-') {
              i++;
              count++;
            }
            else if (i < input.length() - 2) {
              // dz=
              if (input.charAt(i + 1) == 'z' && input.charAt(i + 2) == '=') {
                i += 2;
                count++;
              } else count++;
            } else count++;
            break;
          case 'l':
          case 'n':
            // nj or lj
            if (input.charAt(i + 1) == 'j') {
              i++;
              count++;
            } else count++;
            break;
          case 's':
          case 'z':
            // s= or z=
            if (input.charAt(i + 1) == '=') {
              i++;
              count++;
            } else count++;
            break;
          default:
            count++; break;
        }
      }
    }
    System.out.println(count);
  }
}