import java.util.*; 

class Solution {
    // 1) 여는 괄호일 경우 stack 에 넣고,
    // 2) 닫는 괄호가 경우 stack 에서 pop한다. 
    
    // 3) stack 비었다면 && pop할 때 counting -> 확인
    
    boolean solution(String s) {
        char[] chars = s.toCharArray();
        
        Stack<String> stack = new Stack<>();
        
        int completionCount = 0;
        for(char c : chars) {
            if(c == '(') {
                stack.push("(");
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                    completionCount ++;
                }
            }
        }
        
        if(stack.empty() && completionCount * 2 == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}