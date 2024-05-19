# 깊이 우선 탐색 DFS(Depth-First-Search)
- `브루트 포스 알고리즘`에 사용된다.
- `재귀함수`, `스택`을 사용한다.
- 간단 DFS > BFS
- 속도 DFS < BFS

<details>

  <summary>연산자 끼워넣기</summary>

  [연산자 끼워넣기](https://github.com/kdelay/Algorithm/commit/2c4f0f751d471d3b9c74156d5bc656036bcc533c)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static int[] arr, oper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        //피연산자 input
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //연산자 input
        oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        //dfs 진행 (초기값, 그 다음 값)
        dfs(arr[0], 1);

        //최종 최댓값, 최솟값 출력
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx) {
        //인덱스가 피연산자 길이만큼 도달했을 때 종료
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        //각 연산자 +,-,*,/에 대한 dfs 진행
        for (int i=0; i<4; i++) {
            //연산자 개수가 존재할 때만 진행
            if (oper[i] > 0) {

                //연산자 1개 사용
                oper[i]--;

                switch (i) {
                    case 0: dfs(num + arr[idx], idx + 1); break;
                    case 1: dfs(num - arr[idx], idx + 1); break;
                    case 2: dfs(num * arr[idx], idx + 1); break;
                    case 3: dfs(num / arr[idx], idx + 1); break;
                }

                //재귀함수 호출 종료 후, 연산자 1개 사용 복구
                oper[i]++;
            }
        }
    }
}
```

</details>
