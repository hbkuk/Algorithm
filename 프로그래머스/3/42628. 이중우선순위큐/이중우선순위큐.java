/**

[문제]
- 이중 우선순위 큐 연산
-  1) I 숫자. -> 주어진 숫자 삽입.
-  2) D 1.   -> 최댓값 삭제
-  3) D -1.  -> 최솟값 삭제

[풀이 방식]
- 그러게.. 이걸 어캐풀지. 우선순위 큐.. 두개...?
- 그럼 총 큐가 3개인건가?
- 숫자 

[예외 케이스]
- 빈 큐에 데이터 삭제 -> 오류 없음.
- 배열 길이 10^6 -> 이중 for문으로 처리할 경우 이슈있음.

**/

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 최솟값 저장.
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값 저장
        
        for(String operation : operations) {
            String[] parts = operation.split("\\s+");
            
            String type = parts[0]; // 명령어 유형
            int value = Integer.parseInt(parts[1]); // 명령 값
            
            // System.out.println("type --> " + type);
            // System.out.println("value --> " + value);
            
            if(type.equals("I")) {
                maxQueue.add(value);
                minQueue.add(value);
              
            } else {
                
                // 최댓값 삭제 명령
                if(value == 1) {
                    
                    // 비어있지 않다면
                    if(!maxQueue.isEmpty()) {
                        int max = maxQueue.poll();
                        minQueue.remove(max);
                    }
                
                // 최솟값 삭제 명령
                } else {
                    if(!minQueue.isEmpty()) {
                        int min = minQueue.poll();
                        maxQueue.remove(min);
                    }    
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        
        if(!maxQueue.isEmpty()) {
            answer.add(maxQueue.peek());
        } else {
            answer.add(0);
        }
        
        if(!minQueue.isEmpty()) {
            answer.add(minQueue.peek());
        } else {
            answer.add(0);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}