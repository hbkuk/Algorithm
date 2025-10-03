import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 1. 현재 맞은 개수
        
        // 2. 0인 개수
        
        // 3. 현재 맞은 개수만큼.. 등수를 가져가고, 현재 맞은 개수 + 0인 개수만큼 등수를 가져가기;
        Map<Integer, Integer> 순위_맵핑 = new HashMap<>();
        순위_맵핑.put(6, 1);
        순위_맵핑.put(5, 2);
        순위_맵핑.put(4, 3);
        순위_맵핑.put(3, 4);
        순위_맵핑.put(2, 5);
        순위_맵핑.put(1, 6);
        순위_맵핑.put(0, 6);
        
        
        Set<Integer> 발표_번호_목록 = new HashSet<>();
        for(int 번호 : win_nums) {
            발표_번호_목록.add(번호);
        }
    
        int 맞춘_개수 = 0;
        int 제로_개수 = 0;
        for(int 번호 : lottos) {
            if(번호 == 0) {
                제로_개수 ++;
                continue;
            }
            
            if(발표_번호_목록.contains(번호)) {
                맞춘_개수 ++;
            }
        }
        
        return new int[]{순위_맵핑.get(맞춘_개수 + 제로_개수), 순위_맵핑.get(맞춘_개수)};
    }
}