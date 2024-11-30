import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //국가의 수
            int M = Integer.parseInt(st.nextToken()); //비행기 종류

            //왕복 비행 스케줄
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
            }
            
            //주어지는 비행 스케줄은 항상 연결 리스트이므로, 최대 개수는 N-1 개이다.
            System.out.println(N-1);
        }
    }
}