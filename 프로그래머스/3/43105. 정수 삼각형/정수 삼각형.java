/**
[풀이 방식]
1. DP 방식으로 풀기.

[코드 작성 방식]
1. DP 배열 만들기
2. 배열 첫번째 칸에서부터 시작.
3. 현재 행과 열을 (a,b) 라고 했을때 (a-1) 행에서.. 열은 b, b+1 까지 갱신 가능.
  -> 업데이트는 최대 값을 업데이트한다. Math.max 함수 사용.
4. 전역 변수로 최대 값을 계속 갱싱한다.


[예외 케이스]
1. 숫자 21억 넘는 이슈 -> 없음.
2. 시간 초과 -> X.


*/

import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][triangle[triangle.length -1].length];
        dp[0][0] = triangle[0][0];
        
        // 2중 for문.
        // for문 조건 -1인 이유 -> 마지막 행은 순회할 필요 없음. 그 전 행에서까지만 갱신하면됨.
        for(int i = 0; i < triangle.length - 1; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                // 현재 위치에서 1행 큰 값과 현재 위치에서 1행 큰 값 + 1열 큰값 갱신.
                
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j + 1]);
                
                answer = Math.max(Math.max(answer, dp[i+1][j]), Math.max(answer, dp[i+1][j + 1]));
            }
        }
        
   
        return answer;
    }
}