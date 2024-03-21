import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    stack.push(Integer.valueOf(input[1]));
                    break;
                case "pop":
                    if (stack.empty()) { System.out.println(-1); break; }
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty() ? 1 : 0);
                    break;
                case "top":
                    if (stack.empty()) { System.out.println(-1); break; }
                    System.out.println(stack.peek());
                    break;
            }
        }
    }
}