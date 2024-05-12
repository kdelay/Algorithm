import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.ToLongFunction;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); //시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); //종료 시간
        }

        //종료 시간이 빠른 순으로 정렬
        //종료 시간이 같을 경우 시작 시간이 빠른 순으로 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int t = 0;

        for (int i=0; i<N; i++) {
            //겹치지 않는 경우
            if (t <= time[i][0]) {
                t = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}