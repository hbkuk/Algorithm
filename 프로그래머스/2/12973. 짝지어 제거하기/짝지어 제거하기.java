import java.util.*;
// 짝지어 제거하기
// 알파벳 소문자로 이루어진 문자열
// 2개가 붙어 있는 짝을 찾아, 둘을 제거한 후 앞뒤로 문자열을 이어 붙임.
// 성공적으로 모두 다 제거 가능하다면 1을 반환, 그렇지 않다면 0을 반환
class Solution {
    // 풀이 과정
    // 1. 문자열을 문자 단위로 쪼개어서 Stack에 담는다.
    // 2. 이미 Stack에 담은 것과 다시 담을 것을 비교한다.
    // 3. 같다면 pop하고, 다음 문자로 순서를 넘긴다.
    // 4. 이렇게 하다보면, 모두 다 삭제 가능해진다.
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty()) {
                char preChar = stack.peek();
                if(preChar == c) {
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