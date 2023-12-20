import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty()) {
                char preChar = stack.peek();
                if(c == preChar) {
                    stack.pop();
                    continue;
                }
            } 
            stack.push(c);
        }
        
        if(stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}