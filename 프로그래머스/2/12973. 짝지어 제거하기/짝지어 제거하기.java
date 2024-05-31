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

        //원본 문자열 길이만큼 진행한다.
        for (char c : s.toCharArray()) {
            //stack이 비어있는 경우 값 추가
            if (stack.size() == 0) {
                stack.push(c);
            }
            //마지막 대상과 문자가 동일한 경우 값 제거
            else if (stack.peek() == c) {
                stack.pop();
            }
            //마지막 대상과 문자가 다른 경우 값 추가
            else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}