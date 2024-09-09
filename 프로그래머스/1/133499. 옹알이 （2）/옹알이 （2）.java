class Solution {
    public int solution(String[] babbling) {
        
        String[] speak = new String[]{"aya", "ye", "woo", "ma"};
        String[] noSpeak = new String[]{"ayaaya", "yeye", "woowoo", "mama"};

        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < speak.length; j++) {
                babbling[i] = babbling[i].replaceAll(noSpeak[j], "1").replaceAll(speak[j], " ");
            }
            
            if (babbling[i].trim().length() == 0) answer++;
        }
        return answer;
    }
}