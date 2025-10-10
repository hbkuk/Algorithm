import java.util.*;

class Solution {

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 도형 그리기
        // 2. 도형 내부 파내기
        // 3. BFS 진행해서 가장 짧은 거리 찾기
        
        int[][] map = new int[102][102]; // 모든 좌표 값은 1이상 50이하
        
        // 도형 채우기
        for(int i = 0; i < rectangle.length; i++) {
            int[] 도형_좌표 = rectangle[i];
            
            int 좌측_하단_x = 도형_좌표[0] * 2;
            int 좌측_하단_y = 도형_좌표[1] * 2;
            
            int 우측_상단_x = 도형_좌표[2] * 2;
            int 우측_상단_y = 도형_좌표[3] * 2;
            
            for(int j = 좌측_하단_x; j <= 우측_상단_x; j++ ) {
                for(int k = 좌측_하단_y; k <= 우측_상단_y; k++) {
                    map[k][j] = 1; // 칠하기
                }
            }
        }
        
        // 도형 비우기
        for(int i = 0; i < rectangle.length; i++) {
            int[] 도형_좌표 = rectangle[i];
            
            int 좌측_하단_x = 도형_좌표[0] * 2;
            int 좌측_하단_y = 도형_좌표[1] * 2;
            
            int 우측_상단_x = 도형_좌표[2] * 2;
            int 우측_상단_y = 도형_좌표[3] * 2;
            
            for(int j = 좌측_하단_x + 1; j <= 우측_상단_x - 1; j++ ) {
                for(int k = 좌측_하단_y + 1; k <= 우측_상단_y - 1; k++) {
                    map[k][j] = 0; // 비우기
                }
            }
        }
        
        // bfs 진행
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, map) / 2;
    }
    
    int bfs(int 최초_col, int 최초_row, int itemX, int itemY, int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{최초_row, 최초_col, 1});
        
        visited[최초_row][최초_col] = true;
        
        int[] dr = {-1, 1, 0, 0}; // 상하좌우
        int[] dc = {0, 0, -1, 1};
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            int cr = poll[0]; 
            int cc = poll[1];
            int cd = poll[2];
            
            if(cr == itemY && cc == itemX) {
                return cd;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int nd = cd + 1;
                
                // Map 범위 안 && 외곽선
                if(nr >= 0 && nr <= 100 &&
                   nc >= 0 && nc <= 100 &&
                   !visited[nr][nc] &&
                   map[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc, nd});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return 0; // 무조건 찾을 수 밖에 없음
    }
}