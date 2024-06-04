import java.util.Stack;

class Solution {
    public int solution(String my_string) {
        
        String[] str = my_string.split(" ");
        int result = Integer.parseInt(str[0]);
        
        boolean oper = true;
        
        for (int i = 1; i < str.length; i++) {
            
            if (str[i].equals("-")) oper = false;
            else if (str[i].equals("+")) oper = true;
            else {
                if (oper) { //+
                    result += Integer.parseInt(str[i]);
                } else { //-
                    result -= Integer.parseInt(str[i]);
                }
            }
        }
        
        return result;
    }
}