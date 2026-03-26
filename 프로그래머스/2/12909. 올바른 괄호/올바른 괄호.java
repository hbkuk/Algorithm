/**

<문제>
괄호가 바르게 짝지어져 있다.
-> '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻.

'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해주세요.

<접근 방식>
1. '(' 가 있으면 무조건 짝인 ')' 가 있어야 한다.
2. Stack에 하나씩 넣는다.
3. 문자열 전체를 끝까지 봤는데도 남아있다면 false.

**/

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {

            // 열린 괄호인 경우
            if(c == '(') {
                stack.push('(');
                
            // 닫힌 괄호인 경우
            } else {
                
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}