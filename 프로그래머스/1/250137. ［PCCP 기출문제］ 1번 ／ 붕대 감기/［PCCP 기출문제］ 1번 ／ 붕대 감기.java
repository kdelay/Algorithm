import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int success = bandage[0]; //연속 성공 기준
        int now = health; //현재 체력
        int lastAttack = 0; //마지막 공격 당한 턴
        
        for (int[] attack : attacks) {
            //현재 체력이 없으면 -1 리턴
            if (now <= 0) return -1;
            
            //체력 충전 가능 횟수: 몬스터한테 맞기 전까지 범위만큼
            int healCount = attack[0] - lastAttack - 1;
            //추가 체력 수급 가능 여부: 체력 충전 가능 횟수가 연속 성공 기준에 부합하는지
            int addHeal = healCount / success;
            
            //체력 충전 가능하면 1초당 충전할 수 있는 만큼 충전
            now = Math.min(health, now + (healCount * bandage[1]));
            //가능하면 추가 체력 수급
            now = Math.min(health, now + (addHeal * bandage[2]));
            
            //몬스터 공격
            now -= attack[1];
            lastAttack = attack[0];
        }
        return now <= 0 ? -1 : now;
    }
}