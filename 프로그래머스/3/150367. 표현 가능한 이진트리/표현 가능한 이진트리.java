import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 이진수 변환
            String binary = Long.toBinaryString(numbers[i]);

            // 포화 이진트리 노드 개수로 길이 맞추기 (앞에 0 추가)
            int treeSize = getTreeSize(binary.length());
            
            binary = String.format("%" + treeSize + "s", binary)
                .replace(' ', '0');

            // 재귀적으로 트리 검증 (가능하면 1, 불가능하면 0)
            answer[i] = check(binary, 0, binary.length() - 1) ? 1 : 0;
        }

        return answer;
    }

    // 포화 이진트리의 노드 개수를 구하는 함수
    // 1, 3, 7, 15, 31 ... (2^h - 1 형태)
    private int getTreeSize(int length) {
        // size를 2배씩 증가시키면서 현재 length보다 크거나 같은 최소한의 포화 이진트리 크기를 찾음 (가장 가까운 포화 이진트리 크기)
        int size = 1;
        while (size - 1 < length) {
            size *= 2;
        }
        return size - 1;
    }

    // 이진트리 구조 검사
    private boolean check(String binary, int start, int end) {
        if (start == end) return true; // 리프 노드는 항상 가능

        // 중앙 값을 루프 노드로 설정
        // 이진트리 특징: 루트는 항상 가운데
        int mid = (start + end) / 2;
        char root = binary.charAt(mid);

        // 부모가 '0'인데 자식이 '1'이면 불가능 (왼쪽/오른쪽 서브트리 루트 값이 1인지 확인)
        if (
            root == '0' && 
            (binary.charAt((start + mid - 1) / 2) == '1' || binary.charAt((mid + 1 + end) / 2) == '1')
        ) {
            return false;
        }

        // 왼쪽 서브트리와 오른쪽 서브트리를 재귀적으로 확인 (둘다 유효해야 전체 트리가 유효하므로 && 연산자 사용)
        return check(binary, start, mid - 1) && check(binary, mid + 1, end);
    }
}