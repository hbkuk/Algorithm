/**

<문제 내용>
단 한명의 선수를 제외하고 모든 선수가 마라톤을 완주함.
완주하지 못한 선수의 이름을 return 하도록 함수 작성.

마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하. (=10^5)
참가자 중에는 동명이인.

<접근 방식>
Map<String,Integer> 를 하나 만들어서. 선수들 이름에 해당하는 key에 value를 ++?
-> 그러면은 value 1인 것을 추출해서 ealry return 하는 것도 괜찮을 듯.

**/

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        // value가 1인 것 찾기
        Set<String> keys = map.keySet();
        for(String name : keys) {
            if( map.get(name) == 1) {
                return name;
            }
        }
        
        return null;
    }
}