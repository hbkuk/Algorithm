import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        // Map 생성
        Map<String, Integer> map = new HashMap<>();
        
        // 때려박기
        for(int i =0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }
        
        // 찾기
        for(int i = 0; i < phoneBook.length; i++) {
            for(int j = 0; j < phoneBook[i].length(); j++) {
                if(map.containsKey(phoneBook[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
        
    }
}