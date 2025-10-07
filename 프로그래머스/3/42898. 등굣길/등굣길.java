/*
    오른쪽과 아래쪽으로만 움직여서 이동해보기
    특정 요소에서는 위, 왼쪽에 숫자에 + 1 씩 해가면서 업데이트 한다.
**/
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        // 지도 만들기
        boolean[][] map = new boolean[n][m];
        for(int i = 0; i < puddles.length; i++) {
            int[] 물_좌표 = puddles[i];
            int 물_x좌표 = 물_좌표[0] - 1;
            int 물_y좌표 = 물_좌표[1] - 1;
            
            map[물_y좌표][물_x좌표] = true; // 물에 잠긴 것을 표현
        }
        
        
        // dp 갱신하기
        int[][] dp = new int[n][m];
        
        //  - 최초 위치 1로 설정, 단 물에 잠기지 않은 경우
        for(int i = 0; i < m; i++) {
            if(map[0][i]) {
                break;
            }
            dp[0][i] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(map[i][0]) {
                break;
            }
            dp[i][0] = 1;
        }
    
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                
                int 현재_row = i;
                int 현재_col = j;
                
                // 현재 위치가 물에 잠긴 경우
                if(map[현재_row][현재_col]) {
                    dp[현재_row][현재_col] = 0;
                    continue;
                }
                
                int[] dr = {0, -1}; // 왼, 우
                int[] dc = {-1, 0};
                
                
                int 경로_합산 = 0;
                // 0. Map을 넘어가진 않았는지
                for(int k = 0; k < 2; k++) {
                    int nr = 현재_row + dr[k];
                    int nc = 현재_col + dc[k];
                    
                    경로_합산 += dp[nr][nc];
                }
                
                dp[현재_row][현재_col] = 경로_합산 % 1_000_000_007;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}