/**
    1. 위에서 아래로 이어지는 경로
    2. 아래 칸으로 이동 시, 아래 대각선 왼쪽, 혹은 오른쪽으로 이동 가능
    dp[1] = 7
    dp[2] = 10, 15
    dp[3] = 18, 11, 15
**/

/**
    1. 각 배열의 요소별 최댓 값을 저장한다.
    2. 가장 바닥까지 최댓 값을 저장 후 바닥 중 가장 큰 값을 확인 후 반환한다.
**/
class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i <= triangle.length - 1; i++) {
            for(int k = 0; k <= i; k++) {
                
                // 가장 왼쪽인 경우 -> 오른쪽 대각선만 비교 가능
                if(k == 0) {
                    dp[i][k] = dp[i - 1][k] + triangle[i][k];
                // 가장 오른쪽인 경우 -> 왼쪽 대각선만 비교 가능
                } else if(k == i) {
                    dp[i][k] = dp[i - 1][k - 1] + triangle[i][k];
                // 그 외 모두 -> 오른쪽, 왼쪽 대각선 모두 비교 가능
                } else {
                    // 왼쪽
                    int 왼쪽_값  = dp[i - 1][k - 1] + triangle[i][k];
                    
                    // 오른쪽
                    int 오른쪽_값  = dp[i - 1][k] + triangle[i][k];
                    
                    dp[i][k] = Math.max(왼쪽_값, 오른쪽_값);
                }
            }
        }
        
        // 가장 바닥에서 최댓 값 확인 후 반환.
        int 최댓_값 = 0;
        
        for(int k = 0; k <= dp.length - 1; k++) {
            최댓_값 = Math.max(최댓_값, dp[triangle.length - 1][k]);
        }
        
        return 최댓_값;
    }
}