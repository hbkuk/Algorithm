/**
[풀이 방식]
1. 유저 스킬트리 -> 스킬트리와 상관 없는 스킬 필터링
2. 스킬트리.startWiths(유저스킬트리)
    - true: 가능한 스킬트리
    - false: 불가능한 스킬트리

[예외 케이스]
1. 상관 없는 스킬 필터링 후 -> 아무것도 없을때.. -> true 나와야함.

[성능]
1. 스킬 필터링 -> O(N)
2. startWiths -> O(N)

**/

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees) {
            // System.out.println("현재 스킬 트리 -> " + tree);
            
            StringBuilder sb = new StringBuilder();
            for(char c : tree.toCharArray()) {
                // System.out.println("현재 문자 -> " + c);
                // 찾음
                if(skill.indexOf(c) != -1) {
                    sb.append(c);
                    // System.out.println("skill.charAt(c) -> " + skill.indexOf(c));
                }
            }
            // System.out.println("필터링된 문자열 -> " + sb.toString());
            String target = sb.toString();
            
            // 예외 케이스. 필터링된 문자열의 길이가 0일 경우.
            
            if(skill.startsWith(target)) {
                answer ++;
            }
        }
        
        return answer;
    }
}