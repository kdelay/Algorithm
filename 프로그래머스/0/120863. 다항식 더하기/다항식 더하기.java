class Solution {
    public String solution(String polynomial) {
        
        String[] data = polynomial.replaceAll(" ", "").split("\\+");
        
        int xCnt = 0, valCnt = 0;
        for (String d : data) {
            if (d.contains("x")) {
                if (d.length() > 1) xCnt += Integer.parseInt(d.split("x")[0]);
                else xCnt++;
            }
            else valCnt += Integer.parseInt(d);
        }
        
        String answer;
        if (xCnt > 0) {
            answer = (xCnt != 1) ? (xCnt + "x") : "x";
            if (valCnt > 0) answer += (" + " + valCnt);
        }
        else answer = valCnt+"";
        return answer;
    }
}