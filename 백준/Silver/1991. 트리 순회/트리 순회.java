import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

//tree를 생성하기 위한 Node class
class Node {
    char value;
    //재귀를 통해 Node(부모) <-> Node(자식) 간 연결을 위해 type을 Node로 설정한다.
    Node left;
    Node right;

    //Node 생성자
    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            //부모 노드가 설정되어 있지 않은 경우
            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue);
            }

            //왼쪽 노드(자식)가 있는 경우
            if (leftValue != '.') {
                tree[leftValue - 'A'] = new Node(leftValue);
                //부모 노드와 연결
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];
            }

            //오른쪽 노드(자식)가 있는 경우
            if (rightValue != '.') {
                tree[rightValue - 'A'] = new Node(rightValue);
                //부모 노드와 연결
                tree[parentValue - 'A'].right = tree[rightValue - 'A'];
            }
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }

    //전위순회
    private static void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    //중위순회
    private static void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    //후위순회
    private static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}