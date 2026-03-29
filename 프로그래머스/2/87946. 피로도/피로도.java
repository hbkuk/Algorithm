/**

DFS + 백트래킹 기반으로 문제풀어보기.

<자료구조>
1. visited[] -> 던전 방문여부
2. 탐험한 던전 개수 -> 최댓값 갱신 필요.

<메서드>
1. dfs(int 남은피로도, int 방문할 던전, int 방문했던 던전수)

<구현 방법>
1. 전체 던전을 순서대로 방문한다.
    -> 방문하기 전 방문여부를 체크한다. 재귀가 끝나고 돌아오면서 false로 수정한다.


**/

class Solution {
    
    static boolean[] visited;
    static int[][] map;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        map = dungeons;    
        
        dfs(k, 0);
        return max;
    }
    
    void dfs(int 남은_피로도, int 방문_개수) {
        
        // 1. 오자마자 현재까지의 기록.
        max = Math.max(max, 방문_개수);
        
        // 2. 모든 던전 훑기.
        for(int i = 0; i <= map.length -1; i++) {
            
            // 아직 안갔고, 갈수 있는 피로도인지 확인
            if(!visited[i] && (남은_피로도 >= map[i][0])) {
                visited[i] = true;
                dfs(남은_피로도 - map[i][1], 방문_개수 + 1);
                visited[i] = false;
            }
        }
    }
}