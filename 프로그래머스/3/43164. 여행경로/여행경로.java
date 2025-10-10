import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String 출발_공항 = "ICN";
        
        List<List<String>> 경로_목록 = new ArrayList<>();
        
        List<String> 현재_경로 = new ArrayList<>();
        현재_경로.add(출발_공항);
        
        boolean[] 항공권_사용_여부 = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        dfs(출발_공항, tickets, 현재_경로, 경로_목록, 항공권_사용_여부);
    
        List<String> 가장_첫번째_경로 = 경로_목록.get(0);    
        return 가장_첫번째_경로.toArray(new String[0]);
    }
    
    void dfs(String 출발_공항, String[][] tickets, List<String> 현재_경로, List<List<String>> 경로_목록, boolean[] 항공권_사용_여부) {     
        // 주어진 항공권을 모두 사용한 경우
        if(현재_경로.size() == tickets.length + 1) {
             경로_목록.add(new ArrayList<>(현재_경로));
             return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            // 사용한 경우 스킵
            if(항공권_사용_여부[i]) {
                continue;
            }
            
            // 이륙해보자.
            String[] 사용할_항공권 = tickets[i];
            
            String 시작_공항 = 사용할_항공권[0];
            
            String 도착_공항 = 사용할_항공권[1];
            
            if(출발_공항.equals(시작_공항)) {
                // 사용 여부 체크
                항공권_사용_여부[i] = true;
                
                // 현재 경로 추가
                현재_경로.add(도착_공항);
                
                // 새로운 dfs 진행
                dfs(도착_공항, tickets, 현재_경로, 경로_목록, 항공권_사용_여부);
                
                // 재귀 끝나고 나오면 다른 케이스로 진행되어야 하기 때문에
                항공권_사용_여부[i] = false;
                현재_경로.remove(현재_경로.size() - 1);
            }
        }
    }
}