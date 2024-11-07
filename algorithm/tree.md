# Tree
- 트리 알고리즘
- 루트 노드, 부모 노드, 자식 노드로 이루어져 있다.
- 전위, 중위, 후위 순회 함수를 통해 트리를 순회할 수 있다.

<details>
  
  <summary>tree 순회(전위, 중위, 후위)</summary>

```java
package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/kdelay/study/programmers/src/main/java/algorithm/boj/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 값 받기
        List<Integer> nodes = new ArrayList<>();
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            nodes.add(Integer.parseInt(input));
        }

        //결과 값 저장 변수
        String[] answer = new String[3];

        //전위 순회
        answer[0] = preOrder(nodes, 0).trim();

        //중위 순회
        answer[1] = inOrder(nodes, 0).trim();

        //후위 순회
        answer[2] = postOrder(nodes, 0).trim();

        System.out.println(Arrays.toString(answer));
    }

    private static String preOrder(List<Integer> nodes, int index) {
        //종료 조건
        if (index >= nodes.size()) return "";
        return nodes.get(index) + " " +
                preOrder(nodes, 2 * index + 1) + //왼쪽 자식 노드
                preOrder(nodes, 2 * index + 2); //오른쪽 자식 노드
    }

    private static String inOrder(List<Integer> nodes, int index) {
        //종료 조건
        if (index >= nodes.size()) return "";
        return inOrder(nodes, 2 * index + 1) +
                nodes.get(index) + " " +
                inOrder(nodes, 2 * index + 2);
    }

    private static String postOrder(List<Integer> nodes, int index) {
        //종료 조건
        if (index >= nodes.size()) return "";
        return postOrder(nodes, 2 * index + 1) +
                postOrder(nodes, 2 * index + 2) +
                nodes.get(index) + " ";
    }
}
```

</details>
