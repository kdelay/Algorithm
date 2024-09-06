import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String dartResult) {
        
        int result = 0; //총 점수
        int lastScore = 0; //직전 점수
        int curScore = 0; //현재 점수
        
        for (int i = 0; i < dartResult.length(); i++) {
            
            char c = dartResult.charAt(i);
            
            //10점인 경우
            if (c == '1' && dartResult.charAt(i+1) == '0') {
                result += lastScore; //결과 값에 추가
                lastScore = curScore; //직전 점수 수정
                curScore = 10; //현재 점수는 10점
                i++; //0 건너뛰기
                continue;
            }
            
            //한 자리 숫자인 경우
            if ('0' <= c && c <= '9') {
                result += lastScore; //결과 값에 추가
                lastScore = curScore; //직전 점수 수정
                curScore = c - '0'; //현재 점수 수정
            }
            
            //'S', 'D', 'T' 보너스인 경우
            else if ('A' <= c && c <= 'Z') {
                if (c == 'D') curScore = (int) Math.pow(curScore, 2);
                else if (c == 'T') curScore = (int) Math.pow(curScore, 3);
            }
            
            //'#', '*' 옵션인 경우
            else if (c == '#') curScore *= (-1);
            else if (c == '*') {
                lastScore *= 2;
                curScore *= 2;
            }
        }
        //마지막 모든 수 더하기
        result += (lastScore + curScore);
        return result;
    }
}