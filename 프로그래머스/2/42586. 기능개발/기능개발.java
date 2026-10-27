import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) {
            int rest = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            days[i] = rest;
            // System.out.println("rest -> " + rest);
        }
        
        int base = days[0];
        int count = 1;

        for (int i = 1; i < days.length; i++) {
            if (days[i] > base) {                
                // 현재까지의 카운트 넣기.
                answer.add(count);
                
                // 베이스 및 카운트 초기화.
                base = days[i];
                count = 1;
                
            } else {
                // 지금 묶음에 합류: 무엇을 바꿀까?
                
                // 카운트 추가.
                count ++;
            }
        }
        // 반복문이 끝난 뒤: 마지막 묶음은 어떻게 할까?
        answer.add(count);
           
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}