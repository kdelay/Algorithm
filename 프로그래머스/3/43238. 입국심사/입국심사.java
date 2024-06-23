import java.util.Arrays;

class Solution {
    /**
     * @param n 입국 심사를 기다리는 사람의 수
     * @param times 심사관이 한 명을 심사하는 데 걸리는 시간
     * @return 모든 사람이 심사 받는 데 걸리는 시간의 최솟값
     */
    public static long solution(int n, int[] times) {
        long answer = 0;

        //시간 오름차순 정렬
        Arrays.sort(times);

        long left = 1;
        long right = (long) n * times[times.length-1]; //심사가 가장 오래 걸리는 시간
        long sum = 0;
        answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            sum = 0;
            for (int time : times) {
                //추정시간 값 / 각 심사관 별 심사시간 = 심사관 당 맡을 수 있는 입국자 수
                sum += mid / time;
            }
            if (sum < n) { //실패 -> 시간 늘리기
                left = mid + 1;
            } else { //가능 -> 시간 줄이기
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}