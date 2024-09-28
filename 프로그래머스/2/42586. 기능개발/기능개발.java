import java.util.*;

class Solution {
    // 배포는 progresses 인덱스 오름차순으로 진행
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        // stack에 쌓기
        for(int i = progresses.length - 1; i > -1; i--) {
            stack.push(progresses[i]);
        }
        
        while(!stack.empty()) {
            for(int i = 0; i < stack.size(); i++) {
                stack.set(i, stack.get(i) + speeds[stack.size() -1 - i]);
            }
            
            int count = 0;
            while(!stack.empty() && stack.peek() >= 100) {
                count ++;
                stack.pop();
                progresses = Arrays.copyOfRange(progresses, 1, progresses.length);
                speeds = Arrays.copyOfRange(speeds, 1, speeds.length);
            }
            
            if(count != 0) {
                answer.add(count);
            }
        }
        
        return answer.stream().mapToInt(i ->i).toArray();
    }
}