import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            // 포화 이진트리 노드 개수로 길이 맞추기 (앞에 0 추가)
            int treeSize = getTreeSize(binary.length());
            binary = String.format("%" + treeSize + "s", binary).replace(' ', '0');

            // 재귀적으로 트리 검증
            answer[i] = check(binary, 0, binary.length() - 1) ? 1 : 0;
        }

        return answer;
    }

    // 포화 이진트리의 노드 개수를 구하는 함수
    private int getTreeSize(int length) {
        int size = 1;
        while (size - 1 < length) {
            size *= 2;
        }
        return size - 1;
    }

    // 재귀적으로 이진트리의 유효성을 검사하는 함수
    private boolean check(String binary, int start, int end) {
        if (start == end) return true; // 단일 노드는 항상 가능

        int mid = (start + end) / 2;
        char root = binary.charAt(mid);

        // 부모가 '0'인데 자식이 '1'이면 불가능
        if (root == '0' && (binary.charAt((start + mid - 1) / 2) == '1' || binary.charAt((mid + 1 + end) / 2) == '1')) {
            return false;
        }

        return check(binary, start, mid - 1) && check(binary, mid + 1, end);
    }
}