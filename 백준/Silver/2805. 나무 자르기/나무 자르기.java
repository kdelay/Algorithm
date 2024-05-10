import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        long max = 0;
        long min = 0;

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (max < arr[i]) max = arr[i];
        }

        while (min < max) {

            long result = 0;
            long mid = (min + max) / 2;

            for (long a : arr) {
                if (a - mid > 0) {
                    result += (a - mid);
                }
            }

            if (result < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}