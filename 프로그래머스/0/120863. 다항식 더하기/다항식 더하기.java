class Solution {
    public String solution(String polynomial) {
        
        int xCnt = 0, valCnt = 0;
        for (String poly : polynomial.split(" ")) {
            if (poly.contains("x")) {
                xCnt += (poly.equals("x")) ? 1 : Integer.parseInt(poly.replaceAll("x", ""));    
            }
            else if (!poly.contains("+")) {
                valCnt += Integer.parseInt(poly);
            }
        }
        return ((xCnt > 0) ? (xCnt != 1) ? (xCnt + "x") : "x" : "") + 
            ((valCnt > 0) ? (xCnt > 0) ? (" + " + valCnt) : (valCnt + "") : "");
    }
}