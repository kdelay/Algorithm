import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static final int MAX = 1_000_001;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      Stack<Integer> stack = new Stack<>();
      int[] count = new int[MAX];
      int[] index = new int[N];
      int[] ngf = new int[N];

      //초기값
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i=0; i<N; i++) {
        index[i] = Integer.parseInt(st.nextToken());
        count[index[i]]++;
      }

      for (int i=0; i<N; i++) {
        //큰 수 중에서 가장 왼쪽에 있는 수를 찾기 위해 바로 전 index부터 확인
        while (!stack.isEmpty() && count[index[i]] > count[index[stack.peek()]]) { //stack이 비어있지 않은 상태에서(첫 번째 값은 확인X), F(Ai)보다 큰 값인지 확인
          ngf[stack.pop()] = index[i]; //Ai 값을 ngf에 저장하고, stack index는 제거한다.
        }
        //우측에 큰 값이 있는지 확인하기 위해 index를 stack에 담아둔다.
        stack.push(i);
      }
      //큰 수가 없는 index는 -1 대입
      while (!stack.isEmpty()) {
        ngf[stack.pop()] = -1;
      }

      //결과 출력
      StringBuilder sb = new StringBuilder();
      for (int n : ngf) sb.append(n).append(" ");
      System.out.println(sb);
    }
}