import java.util.*;

class Solution {
    
    public int[] solution(int k, int[] score) {
        
        // 명예의 전당
        List<Integer> 전당 = new ArrayList<>();
        
        // 최하위 점수 목록
        List<Integer> 최하위_점수_목록 = new ArrayList<>();
        
        for(int i = 0; i <= score.length - 1; i++) {
            int 점수 = score[i];
            
            Collections.sort(전당);
            
            // 만약 아직 전당이 채워지지 않았을 경우
            if(k > 전당.size() ) {
                전당.add(점수);
            } else {
                
                int 현_최하위_점수 = 전당.get(0);
                
                // 전당이 다 채워졌으면서 && 만약 갱신 가능할 경우
                if(점수 > 현_최하위_점수) {
                    전당.remove(0); // 첫번째 값 삭제
                    전당.add(점수);
                }    
            }
            
            
            Collections.sort(전당); // 우선 오름차순 정렬
            
            최하위_점수_목록.add(전당.get(0));
        }
        
        return 최하위_점수_목록.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}