class Solution {
    public int[] solution(String s) {
        
        //answer[0]: 이진 변환 횟수, answer[1]: 0 제거 개수
        int[] answer = new int[2];
        
        //s 가 1이면 중단
        int tmp = 0;
        while (!s.equals("1")) {
            answer[1] += s.length(); //s 초기 길이
            s = s.replaceAll("0", ""); //정규식으로 0 제거
            tmp = s.length(); //0이 제거된 s 길이
            
            s = Integer.toBinaryString(tmp); //이진법 진행
            
            answer[1] -= tmp; //초기 길이 - 0 제거 길이
            answer[0]++; //이진 변환 횟수
        }
        return answer;
    }
}