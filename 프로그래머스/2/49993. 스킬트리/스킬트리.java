/**

문제: 유저 스킬 트리 중 가능한 스킬트리 개수 return

접근 방식: 선행 스킬 순서의 알파벳을 제외한 알페벳 필터링 후 가능한 스킬트리 개수 세기.

세부 방식:
1. 유저 스킬 트리 순회.
2. 선행 스킬 순서의 알파벳을 제외 후 목록 저장.
3. 선행 스킬로 문자열이 시작하는지 확인.
  - 시작: 카운트 
  - 시작안함: 노 카운트

예외 케이스:
1. 알파벳 제외 후 빈 문자열일 경우 -> 카운팅 되어야함.

**/

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        List<String> filtered_trees = new ArrayList<>();
        for(String tree : skill_trees) {
            
            StringBuilder sb = new StringBuilder();
            for(char c : tree.toCharArray()) {
                if(skill.indexOf(c) != -1) {
                    sb.append(c);
                }
            }
            
            System.out.println(sb.toString());
            filtered_trees.add(sb.toString());
        }
        
        int answer = 0;
        for(String tree : filtered_trees) {
            if(skill.startsWith(tree)) {
                answer ++;
            }
        }
        
        return answer;
    }
}