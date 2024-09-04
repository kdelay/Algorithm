import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int skill = bandage[0], heal = bandage[1], addHeal = bandage[2];
        
        int lastTurn = 0;
        Map<Integer, Integer> monster = new HashMap<>();
        for (int[] attack : attacks) {
            monster.put(attack[0], attack[1]);
            lastTurn = attack[0];
        }
        
        //몬스터 공격 횟수만큼 진행
        int count = 0, maxHealth = health;
        for (int i = 1; i <= lastTurn; i++) {
            
            //몬스터가 공격하는 턴이 있는 경우
            if (monster.containsKey(i)) {
                health -= monster.get(i); //몬스터 공격
                count = 0; //연속 성공 실패
                
                //체력이 없는 경우
                if (health <= 0) return -1;
                continue;
            }
            
            health += heal; //체력 회복
            count++; //연속 성공
            
            //연속 치료에 성공한 경우, 추가 회복
            if (count == skill) {
                health += addHeal;
                count = 0;
            }
            
            //이미 최대 체력인 경우, 변동사항 없음
            if (health > maxHealth) health = maxHealth;
        }
        return health;
    }
}