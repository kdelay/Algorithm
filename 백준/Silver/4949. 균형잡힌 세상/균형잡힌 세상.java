import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String input = br.readLine();
      if (input.equals(".")) break;

      Stack<String> stack = new Stack<>();

      String[] arr = input.split("");
      for (String a : arr) {
        switch (a) {
          case ("("):
          case ("["):
            stack.push(a);
            break;
          case (")"):
            if (!stack.isEmpty() && stack.peek().equals("(")) stack.pop();
            else stack.push(")");
            break;
          case ("]"):
            if (!stack.isEmpty() && stack.peek().equals("[")) stack.pop();
            else stack.push("]");
            break;
        }
      }

      if (stack.isEmpty())
        System.out.println("yes");
      else {
        System.out.println("no");
      }
    }
  }
}
