class Solution {
    
    public static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        // 각 노드에서 다른 노드와 연결된 노드가 있을 경우 DFS를 진행한다.
        //     - 이동할 수 있는 경우 answer + 1을 한다.
        //     - 만약, 방문한 경우 동일한 노드는 방문하지 않는다.
        boolean[] visited = new boolean[n]; // 노드 방문 정보
        
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer ++;   
            }
        }
        
        return answer;
    }
    
    public void dfs(int nodeIndex, int[][] computers, boolean[] visited) {
        visited[nodeIndex] = true; // 미리 방문표시
        
        for(int i = 0; i < computers[nodeIndex].length; i++) {
            // 방문하지 않았거나, 1인 경우 방문한다.
            if(i != nodeIndex && computers[nodeIndex][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}