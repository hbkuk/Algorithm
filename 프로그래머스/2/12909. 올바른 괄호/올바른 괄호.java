/**
[접근방식]
- 열린 괄호가 있다면 Stack에 하나씩 넣는다.
- 닫힌 괄호를 만났을때 Stack에서 뺀다.
    - 비어있다면 -> '올바르지 않은 괄호'
- 순회 끝났을 때 Stack 상황
    - 비어있다면 -> '올바른 괄호'
    - 비어있지 않다면 -> '올바르지 않은 괄호'

[엣지케이스]
- 

**/

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for(char c :s.toCharArray()) {
            if(c == '(') {
                stack.push("(");
            } else {
                // 닫힌 괄호를 만났을때 Stack에서 뺀다.
                //  비어있다면 -> '올바르지 않은 괄호'
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        // 순회 끝났을 때 Stack 상황
        // 비어있다면 -> '올바른 괄호'
        // 비어있지 않다면 -> '올바르지 않은 괄호'
        if(stack.isEmpty()) {
            return true;    
        }
        return false;
    }
}