import java.util.*;

class Solution {
    
    static int[] dr = {-1, 1, 0, 0}; // 상,하,좌,우
    static int[] dc = {0, 0, -1, 1};
    
    /** 
        해당 문제는 BFS로 문제를 푼다.
        모든 경우의 수를 확인해서 가장 빠르게 도착한 값을 리턴하면 된다.
    */
    public int solution(int[][] maps) {
        boolean[][] 방문_여부 = new boolean[maps.length][maps[0].length];
        
        return bfs(0, 0, maps, 방문_여부); // 0,0 에서 출발해서 가장 빨리 도착한 값을 리턴한다.
    }
    
    int bfs(int row, int col, int[][] 맵, boolean[][] 방문_여부) {
        // 우선 방문 체크
        방문_여부[row][col] = true;
        
        // 큐에 우선 넣기
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col, 1}); // row, col, 칸수)
        
        // 큐가 빌때까지 반복
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            int cr = poll[0]; // 현재 row
            int cc = poll[1]; // 현재 col
            int cp = poll[2]; // 현재 point
            
            if(cr == 맵.length - 1 && cc == 맵[0].length - 1) {
                return cp; // 찾은 경우
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int np = cp + 1;
                
                // Map 범위 안 && 노방문 && 벽 아님
                if(nr >= 0 && nr <= 맵.length - 1 &&
                  nc >= 0 && nc <= 맵[0].length - 1 &&
                   !방문_여부[nr][nc] && 맵[nr][nc] == 1) {
                    방문_여부[nr][nc] = true;
                    queue.add(new int[]{nr, nc, np});
                }   
            }
        }
        
        return -1; // 찾지 못한 경우
    }
}