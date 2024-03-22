import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    last = Integer.valueOf(input[1]);
                    queue.add(last);
                    break;
                case "pop":
                    if (queue.isEmpty()) { System.out.println(-1); break; }
                    System.out.println(queue.remove());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if (queue.isEmpty()) { System.out.println(-1); break; }
                    System.out.println(queue.element());
                    break;
                case "back":
                    if (queue.isEmpty()) { System.out.println(-1); break; }
                    System.out.println(last);
                    break;
            }
        }
    }
}