class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        // 물에 잠긴 지역 표시
        boolean[][] map = new boolean[n][m];
        for (int[] puddle : puddles) {
            int row = puddle[1] - 1;
            int col = puddle[0] - 1;
            map[row][col] = true;
        }

        // DP 배열 생성 및 초기화
        int[][] dp = new int[n][m];
        dp[0][0] = 1; // 시작 위치
        
        // 맵을 순차적을 순회하면서, 도달할 수 있는 경로를 카운팅한다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (i == 0 && j == 0) { // 집인 경우 
                    dp[i][j] = 1;
                    continue;
                }
                if (map[i][j]) { // 웅덩이인 경우
                    dp[i][j] = 0;
                    continue;
                }

                if(i > 0) { // 위에서 온 경우
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % 1_000_000_007;
                }
                
                if(j > 0) { // 좌측에서 온 경우
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % 1_000_000_007;
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}