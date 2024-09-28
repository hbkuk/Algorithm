import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 동명이인 고려 -> 카운팅        
        Map<String, Integer> participantMap = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            Integer count = participantMap.get(participant[i]);
            if(count == null) {
                participantMap.put(participant[i], 1);
            } else {
                participantMap.put(participant[i], count + 1);
            }
        }
        
        // TODO: compeletion를 순회하면서 카운팅 삭제
        for(int i =0; i < completion.length; i++) {
            Integer count = participantMap.get(completion[i]);
            participantMap.put(completion[i], count - 1);
        }
        
        // TODO: 카운팅 남아있는 것 찾기
        for(int i = 0; i < participant.length; i++) {
            Integer count = participantMap.get(participant[i]);
            if(count != 0) {
                return participant[i];
            }
        }
        return null;
    }
}