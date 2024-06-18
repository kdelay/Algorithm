import java.util.*;

class Solution {
    /**
     * @param enroll 판매원 이름 배열 (center 제외)
     * @param referral 다단계 조직에 참여시키 다른 판매원의 이름 배열
     * @param seller 판매량 집계 데이터 - 판매원 이름 배열
     * @param amount 판매량 집계 데이터 - 판매 수량 배열
     * @return
     */
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        //부모-자식 관계 해시맵 생성
        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        //total 금액 해시맵 생성
        HashMap<String, Integer> total = new HashMap<>();

        //이익 분배
        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i]; //판매자
            int money = amount[i] * 100; //판매자가 판매한 총 금액

            //판매자로부터 차례대로 상위 노드로 이동하며 이익 분배
            while (money > 0 && !curName.equals("-")) {
                //현재 판매자가 받을 금액 계산(10%를 제외한 금액)
                total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
                curName = parent.get(curName);
                
                //10%를 제외한 금액 계산
                money /= 10;
            }
        }
        
        //모든 노드에 대해 해당하는 이익을 배열로 반환
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}