import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int 정답 = 0;
        
        boolean[] 방문_여부 = new boolean[n];    
        for(int i = 0; i < n; i++) {
            if(!방문_여부[i]) {
                System.out.println("bfs를 시작합니다.: " + i);
                bfs(i, computers, 방문_여부);
                정답 ++;   
            }
        }
        return 정답;
    }
    
    public void bfs(int index, int[][] computers, boolean[] 방문_여부) {
        // 1. 방문 체크..
        방문_여부[index] = true;
        
        // 다른 네트워크들 방문하기..
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        
        while(!queue.isEmpty()) {
            int 현재_인덱스 = queue.poll();
            int[] 현재_연결된_컴퓨터_목록 = computers[현재_인덱스];
            for(int i = 0; i < 현재_연결된_컴퓨터_목록.length; i++) {
                // 자신이 아니면서 && 연결되었으면서 && 방문하지 않은 경우
                if (현재_인덱스 != i && 현재_연결된_컴퓨터_목록[i] == 1 && !방문_여부[i]) {
                    queue.add(i);
                    방문_여부[i] = true;
                }
            }
        }
    }
}