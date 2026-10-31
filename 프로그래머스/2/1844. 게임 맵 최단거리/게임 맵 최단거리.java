/**
[문제 분석]
1. BFS/DFS 푸는 문제임.

[풀이 방식]
1. 탐색할 곳을 저장해두는 Queue & visited 배열 만들기.
2. Queue에서 하나씩 꺼내서 상하좌우 이동할 수 있는지 확인한다.
3.   -  맵 범위 안인지 & 방문 안했던 곳인지 & 벽에 막혀있지 않은지

[예외 케이스]
1. 도착할 수 없음 -> -1

**/

import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int tRow = maps.length - 1; // 목표 row
        int tCol = maps[0].length - 1; // 목표 col
        
        Queue<int[]> queue = new LinkedList<>(); // 탐색할 곳 담을 queue
        boolean[][] visited = new boolean[maps.length][maps[0].length]; // 방문 여부 체크.
        
        queue.add(new int[]{0, 0, 1}); // row,col,count
        visited[0][0] = true; // 방문 체크.
        
        int answer = -1;
        
        // 큐가 빌떄까지 진행.
        while(!queue.isEmpty()) {
            int[] current = queue.poll(); // queue에서 꺼내기.
            
            int cRow = current[0]; // 현재 row
            int cCol = current[1]; // 현재 col
            int cCount = current[2]; // 현재 count
            
            // 현재 위치가 목표점인지 확인.
            if(cRow == tRow && cCol == tCol) {
                return cCount;
            }
            
            // 다음 탐색 위치 선정
            int[] dr = {-1, 1, 0, 0}; // 상하좌우
            int[] dc = {0, 0, -1, 1}; // 상하좌우
            
            for(int i = 0; i < 4; i++) {
                int nRow = cRow + dr[i];
                int nCol = cCol + dc[i];
                
                // 맵 범위 안인지 & 방문 안했던 곳인지 & 벽에 막혀있지 않은지
                if(
                    nRow >= 0 && nRow < maps.length && nCol >= 0 && nCol < maps[0].length &&
                    !visited[nRow][nCol] &&
                    maps[nRow][nCol] != 0   
                ) {
                    queue.add(new int[]{nRow, nCol, cCount + 1}); // row,col,count
                    visited[nRow][nCol] = true; // 방문 체크.
                }
            }
        }
        
        return answer;
    }
}