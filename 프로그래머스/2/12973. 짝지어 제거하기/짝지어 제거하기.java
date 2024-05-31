import java.util.ArrayDeque;

class Solution
{
    /**
     * @param s 문자열
     * @return 성공 1, 실패 0
     */
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int lenS = s.length();

        char[] chars = new char[lenS];
        for (int i = 0; i < lenS; i++) {
            //char 형으로 변환한다.
            chars[i] = s.charAt(i);
        }

        //원본 문자열 길이만큼 진행한다.
        for (int i = 0; i < lenS; i++) {
            //stack이 비어있지 않은 경우만 로직 수행 가능
            if (!stack.isEmpty()) {
                //stack에서 비교할 대상을 꺼낸다.
                char compare = stack.peek();

                //동일한 값: pop
                if (compare == chars[i]) {
                    stack.pop();
                }
                //다른 값: push
                else {
                    stack.push(chars[i]);
                }
            }
            //비어있는 경우는 값을 추가한다.
            else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}