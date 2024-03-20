import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] card = new int[N];
        String[] input1 = br.readLine().split(" ");
        for (int i=0; i<input1.length; i++) card[i] = Integer.parseInt(input1[i]);

        for (int i=0; i<N; i++) {
            if (map.containsKey(card[i])) {
                int value = map.get(card[i]) + 1;
                map.replace(card[i], value);
            } else {
                map.put(card[i], 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int[] haveCard = new int[M];
        for (int i=0; i<input2.length; i++) haveCard[i] = Integer.parseInt(input2[i]);

        for (int i=0; i<M; i++) {
            if (map.containsKey(haveCard[i])) {
                sb.append(map.get(haveCard[i])).append(" ");
            } else {
                sb.append("0 ");
            }

        }

        System.out.println(sb);
    }
}