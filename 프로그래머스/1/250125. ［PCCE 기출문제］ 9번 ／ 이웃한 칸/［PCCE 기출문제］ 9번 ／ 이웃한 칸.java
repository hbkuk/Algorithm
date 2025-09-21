class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int 보드_크기 = board.length; // 가로,세로는 항상 같음.
        
        int 같은_색_개수 = 0;
        
        int[] dr = {-1, 1, 0, 0};  // 상하좌우
        int[] dc = {0, 0, -1, 1};
        
        for(int i = 0; i < 4; i++) {

            int nr = h + dr[i]; // 인접 row
            int nc = w + dc[i]; // 인접 col
            
            // 보드 범위 내에 있는지 확인
            if((nc >= 0 && nc <= 보드_크기 - 1) &&
                (nr >= 0 && nr <= 보드_크기 - 1)) {
                if(board[h][w].equals(board[nr][nc])) {
                    같은_색_개수 ++;
                }
            }
        }
        
        
        return 같은_색_개수;
    }
}