import java.util.HashSet;

/**
 * 1 배열에서 두 수를 구하는 모든 경우의 수를 구한다.
 * 자신보다 뒤에 있는 수를 선택한다.
 * 2 과정 1에서 구한 수를 새로운 배열에 저장하고 중복값을 제거한다.
 * 3 배열을 오름차순으로 정렬하고 반환한다.
**/

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>(); //중복값 제거를 위한 HashSet
        
        //두 수를 선택하는 모든 경우의 수
        for (int i=0; i<numbers.length-1; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                //결과 HashSet에 추가
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        //오름차순으로 정렬하고 int[]로 변환하여 반환
        return set.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}