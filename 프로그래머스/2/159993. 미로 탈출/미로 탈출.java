/**

<문제 분석>
통로들 중 미로를 빠져나가는 문이 있음.
-> 레버를 당겨야만 열 수 있음.

<필요한 자료구조>
1. boolean visited[][][] -> 방문여부 [레버당김여부][row][col]
2. queue -> 방문 내용들 담기

<구현방식>
1. 'START -> 레버' 까지의 최단 시간과 '레버 -> EXIT'  까지의 최단 시간을 구한다.
    - 방문여부는 별도로 관리한다.
    - 단, 둘중 하나라도 '-1' 반환될 경우 -1을 반환한다.
    
<필요한 메서드>
1. bfs -> int bfs(start 좌표, end 좌표)  -> 시작 좌표와 종료 좌표를 받아서 최단 시간을 반환한다.
**/

import java.util.*;

class Solution {
    String[][] map; // 맵
    boolean[][][] visited; // 방문여부 -> [레버당김여부][row][col]
    
    static int startR; // 시작 row
    static int startC; // 시작 col
    
    static int reverR; // 레버 row
    static int reverC; // 레버 col
    
    static int endR; // 종료 row
    static int endC; // 종료 col
    
    public int solution(String[] maps) {
        // 1. maps 다시 정리하기
        map = new String[maps.length][maps[0].length()];
        visited = new boolean[2][maps.length][maps[0].length()];
        
        for(int i = 0; i <= maps.length - 1; i++) {
            String[] arr = maps[i].split("");
            for(int j = 0; j <= maps[0].length() - 1; j++) {
                String value = arr[j];
                map[i][j] = value;
                
                // 2. 시작 위치, 레버 위치, 종료 위치 저장하기
                if(value.equals("S")) {
                    startR = i;
                    startC = j;
                }
                else if(value.equals("L")) {
                    reverR = i;
                    reverC = j;
                    
                } else if(value.equals("E")) {
                    endR = i;
                    endC = j;
                }
            }
        }
        
        // 3. 각각 bfs 진행하기.
        int timeA = bfs(startR, startC, reverR, reverC, 0, false);
        if(timeA == -1) {
            return -1;
        }
        
        int timeB = bfs(reverR, reverC, endR, endC, 0, true);
        if(timeB == -1) {
            return -1;
        } else {
            return timeA + timeB;
        }
    }
    
    int bfs(int cR, int cC, int tR, int tC, int time, boolean isPulled) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{cR, cC, tR, tC, time});
        
        int visitedType = isPulled ? 1 : 0;
        
        // 최초 방문 체크.
        visited[visitedType][cR][cC] = true;
        
        while(!queue.isEmpty()) {
            int[] polled = queue.poll();
            
            int cr = polled[0];
            int cc = polled[1];
            int tr = polled[2];
            int tc = polled[3];
            int cTime = polled[4];
            
            // 목표 찾음 체크
            if(cr == tr && cc == tc) {
                return cTime;
            }
            
            int[] dr = {-1, 1, 0, 0}; // 상하좌우
            int[] dc = {0, 0, -1, 1}; // 상하좌우
            
            // 못찾았으면 다음 통로로 진행해야함.
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                // 다음 위치가 맵에 포함되었는지 & 이미 방문하지 않았는지 & 벽은 아닌지
                if(nr >= 0 && nr <= map.length - 1 &&
                    nc >= 0 && nc <= map[0].length -1 &&
                    !visited[visitedType][nr][nc] &&
                    !map[nr][nc].equals("X")) {
                   
                    visited[visitedType][nr][nc] = true;
                    queue.offer(new int[]{nr, nc, tr, tc, cTime + 1});
                }
            }
        }
        
        return -1;
    }
}