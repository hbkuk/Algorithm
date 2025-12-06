import java.util.*;

class Solution {
    // 1. target 을 만들기 위해서 최소 몇번 눌러야 가능한지
    //  - keymap을 전체 순회하면서 최소 값을 찾아야한다.
    public int[] solution(String[] keymap, String[] targets) {
        
        List<Integer> result = new ArrayList<>();
        
        for(String 목표 : targets) {
            
            int 총_카운트 = 0;
            boolean 만듦 = true;
            for(char c : 목표.toCharArray()) {
                
                // key map을 순회하면서 최소 카운트 찾기
                int 최소_카운트 = Integer.MAX_VALUE;
                for(String map : keymap) {
                    int 찾은_인덱스 = map.indexOf(c);
                    
                    // 찾았으면
                    if(찾은_인덱스 != -1) {
                        최소_카운트 = Math.min(찾은_인덱스 + 1, 최소_카운트);
                    }
                }
                
                // Keymap에서 만들 수 없는 경우
                if(최소_카운트 == Integer.MAX_VALUE) {
                    만듦 = false;
                    break;
                } else {
                    총_카운트 += 최소_카운트;
                }
            }
            if(만듦) {
                result.add(총_카운트);
            } else {
                result.add(-1);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}