import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 문자열 회전: 괄호 문자를 왼쪽으로 한 칸씩 밀고, 맨 앞의 괄호 문자를 맨 뒤로 보낸다.
     * @param s (원본) 괄호 문자열
     * @return 올바른 괄호 문자열 개수
     */
    public int solution(String s) {
        //괄호 짝을 미리 선언해둔다.
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        int length = s.length(); //원본 문자열 길이
        //회전 대신 문자열의 길이를 늘려서 확인한다.
        s += s;
        int answer = 0;

        A: for (int i = 0; i < length; i++) {
           ArrayDeque<Character> stack = new ArrayDeque<>();

            //s 배열 값을 순회하면서 닫힌 괄호가 있는지 확인한다.
            for (int j = i; j < i + length; j++) {

                char c = s.charAt(j);

                //열린 괄호: stack에 추가
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                //닫힌 괄호: 비교
                else {
                    //stack이 비어있거나 짝이 안 맞는 괄호인 경우는 올바른 괄호가 아니다. A로 되돌아간다.
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            //continue 되지 않고, 스택이 비어있으면 올바른 괄호 문자열이다.
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}