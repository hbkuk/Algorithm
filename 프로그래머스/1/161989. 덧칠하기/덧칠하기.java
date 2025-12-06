import java.util.*;

class Solution {
    /**
     시간 복잡도: 최대 10^5
     1. section를 모두 순회하면서 페인트를 칠한다.
     2. 단, 롤러의 크기만큼 칠해지니, 페인트를 칠한 후 동기화를 한다.
    **/
    public int solution(int n, int m, int[] section) {
        boolean[] 페인트_칠_여부 = new boolean[n + 1];
        Arrays.fill(페인트_칠_여부, true);
        
        // 칠 해야하는 곳은 초기 false로 설정
        for(int num : section) {
            페인트_칠_여부[num] = false;
        }
        
        int 페인트_칠_횟수 = 0;
        // section 순회하면서 페인트 칠하기
        for(int num : section) {
            
            // 이미 페인트가 칠되지 않았다면
            if(!페인트_칠_여부[num]) {
                 
                페인트_칠_횟수 ++; // 칠하기 
                
                int 칠_구간 = Math.min((num + m) - 1, n); // 롤러 너비만큼 더 칠하기
                for(int i = num; i <= 칠_구간; i++) {
                    페인트_칠_여부[i] = true;
                }
            }
        }
        
        
        return 페인트_칠_횟수;
    }
}