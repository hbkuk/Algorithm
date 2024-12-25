import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 항공권 데이터 Map에 저장
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            String dep = ticket[0];
            String arv = ticket[1];
            
            PriorityQueue<String> queue = map.get(dep);
            if(queue == null) {
                queue = new PriorityQueue<String>();
            }
            queue.add(arv);
            map.put(dep, queue);
        }
        
        // 경로 저장 Path 만들기
        List<String> path = new ArrayList<>();
        
        dfs("ICN", map, path);
        
        // 저장된 경로 반전
        Collections.reverse(path);
        
        // 경로 출력
        String[] answer = new String[path.size()];
        for(int i = 0; i < path.size(); i++) {
            answer[i] = path.get(i);
        }
        
        return answer;
    }
    
    public void dfs(String current, Map<String, PriorityQueue<String>> map, List<String> path) {
        PriorityQueue<String> nextList = map.get(current); 
        
        // 다음 경로가 있을 경우
        while(nextList != null && !nextList.isEmpty()) { 
            String next = nextList.poll();
            dfs(next, map, path);
        }
        
        // 경로에 해당 위치 추가하기
        path.add(current);
    }
}