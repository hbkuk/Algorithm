import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                // 닫는 괄호가 나왔을 때 스택이 비어 있으면 잘못된 괄호열
                if (stack.empty()) {
                    return false;
                }
                stack.pop(); // 짝 맞추기
            }
        }
        
        // 모든 처리가 끝난 후 스택이 비어 있으면 올바른 괄호열
        return stack.empty();
    }
}
