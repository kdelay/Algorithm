import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    String input = br.readLine();
    for (int i=0; i<input.length(); i++) stack1.push(input.charAt(i)); // 초기값

    int M = Integer.parseInt(br.readLine());
    for (int i=0; i<M; i++) {
      String a = br.readLine();
      char c = a.charAt(0);
      switch (c) {
        case 'L':
          if (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
          }
          break;
        case 'D':
          if (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
          }
          break;
        case 'B':
          if (!stack1.isEmpty()) {
            stack1.pop();
          }
          break;
        case 'P':
          stack1.push(a.charAt(2));
          break;
      }
    }
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    StringBuilder sb = new StringBuilder();
    while (!stack2.isEmpty()) {
      sb.append(stack2.pop());
    }
    System.out.println(sb);
  }
}