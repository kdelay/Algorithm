class Solution {
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (isPrime(tmp)) count++;    
                }
            }
        }
        return count;
    }
    
    private boolean isPrime(int number) {
        //1 이하는 소수가 아님
        if (number <= 1) return false;
        //2 소수
        if (number == 2) return true;
        //짝수는 소수가 아님
        if (number % 2 == 0) return false;
        //3부터 제곱근까지 확인
        for (int i = 3; i <= Math.sqrt(number); i+= 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}