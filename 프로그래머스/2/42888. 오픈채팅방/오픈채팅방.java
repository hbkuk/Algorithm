/**
[문제 접근 방식]
1. 들어온 순서/액션 저장한다. -> queue 구조. class Action -> type, userId
2. 유저 아이디의 최종 닉네임 갱신 -> map 구조. Map<유저아이디, 닉네임>

[엣지 케이스]
1. 2중 fora문 X -> 10^5 시간 복잡도
2. 잘못된 입력 ? -> X.

**/

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Queue<Action> queue = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String value : record) {
            String[] arr = value.split(" ");
            
            String type = arr[0];
            String username = arr[1];
            
            // 입장
            if(type.equals("Enter")) {
                // System.out.println("Enter 닉네임 변경 전 -> " + map.get(username));
                
                String nickname = arr[2];
                
                queue.add(new Action(type, username));
                map.put(username, nickname);
                
                // System.out.println("Enter 닉네임 변경 후 -> " + map.get(username));
                
            // 퇴장
            } else if (type.equals("Leave")) {
                queue.add(new Action(type, username));
                
            // 닉네임 변경
            } else {
                // System.out.println("Change 닉네임 변경 전 -> " + map.get(username));
                
                String nickname = arr[2];
                
                queue.add(new Action(type, username));
                map.put(username, nickname);
                
                // System.out.println("Change 닉네임 변경 후 -> " + map.get(username));
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for(Action ac : queue) {
            String type = ac.type;
            String username = ac.username;
           
            if(type.equals("Enter")) {
                result.add(String.format("%s님이 들어왔습니다.", map.get(username)));
            } else if (type.equals("Leave")) {
                result.add(String.format("%s님이 나갔습니다.", map.get(username)));
            }
        }
        
        return result.stream().toArray(String[]::new);
    }
}

class Action {
    String type;
    String username;
    
    Action (String type, String username) {
        this.type = type;
        this.username = username;
    }
}