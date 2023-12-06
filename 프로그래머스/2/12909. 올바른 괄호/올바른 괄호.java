import java.util.*;

class Solution {
    // 괄호가 제대로 닫혀있는지 확인하는 함수 작성
    boolean solution(String s) {
        // 조건
        // 1. 문자열 s의 길이 100,000 이하
        // 2. 문자열 s는 '('' 또는 ')' 이루어짐
        
        // 코드
        // => 맨앞에는 '(' 이고 맨 뒤에는 ')'인지 확인하면 되는거 아닌가?
        // 1. ( 이 나올때 마다 stack에 담는다.
        // 2. ) 이 나온다면 stack에서 뺀다
        //  - stack에 남아있는 (가 없다면 false를 리턴한다.
        // 3. stack에 남아있다면 false를 리턴한다.
        
        Stack<Integer> stack = new Stack<Integer>();
        
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c == '(') {
                stack.push(1);
            }
            if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()) {
            return true;   
        }
        return false;
    }
}