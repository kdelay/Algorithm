import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) System.out.println(isPs(br.readLine()));
    }

    public static String isPs(String ps) {
        Stack<Character> st = new Stack<>();

        for (int i=0; i<ps.length(); i++) {
            char c = ps.charAt(i);

            if (c == '(') st.push(c);
            else if (st.empty()) return "NO";
            else st.pop();
        }

        if (st.empty()) return "YES";
        else return "NO";
    }
}