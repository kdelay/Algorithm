import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            members[i] = new Member();
            members[i].age = Integer.parseInt(st.nextToken());
            members[i].name = st.nextToken();
        }

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.age - o2.age;
            }
        });

        for (int i=0; i<N; i++) System.out.println(members[i].age + " " + members[i].name);
    }

    static class Member {
        int age;
        String name;
    }
}