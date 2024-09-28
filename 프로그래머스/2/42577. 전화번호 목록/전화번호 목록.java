import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 맵 생성
        Map<String, Integer> map = new HashMap<>();
        
        // 맵 담기
        for(String phone_number : phone_book) {
            map.put(phone_number, 1);
        }
        
        // 맵에서 찾기
        for(String phone_number : phone_book) {
            String prefix = "";
            for(int i = 0; i < phone_number.length() - 1; i++) {
                prefix += phone_number.charAt(i);
                if(map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}