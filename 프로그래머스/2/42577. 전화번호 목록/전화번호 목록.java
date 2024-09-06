import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        for (String phone : phone_book) {
            //가지고 있는 문자열 길이만큼만 비교
            for (int i = 0; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) return false;
            }
        }
        return true;
    }
}