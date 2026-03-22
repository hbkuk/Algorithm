/** 

[배경 지식]
야근을 하면 야근 피로도가 쌓임.
-> 야근 피로도: 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값.

[목표]
1. N시간 동안 야근 피로도를 최소화하도록 일함.
2. 작업자는 1시간 동안 작업량 1만큼을 처리할 수 있음.
3. 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값은?

[문제 접근 방식]
- 최소화할 수 있는 방법이 뭘까? => 야근 피로도는 일의 작업량의 제곱이다보니. 큰 숫자를 없애는게 목표임. 그렇다면.. for문으로 순회하면서 최댓값을 찾아서 하나씩 처리한는게 과연 성능상 문제가 없을까? -> 어떤 방법이 좋을까?

우선. 값이 어떻게 주어지는 확인해보자.

작업 요소의 길이: works.length -> 2 x 10^4
퇴근까지 남은 시간: 1 x 10^7

이 문제는... 최대 힙방식으로 풀어볼 수 있지 않을까?
-> 그렇다면. 최댓값을 매번 pop()해서 뺀 숫자를 add 하는 방법인가?
-> 어찌됐든 이렇게 해도 작업 요소의 길이는 2 x 10^4 라서.. 시간이 그렇게 복잡하진 않을듯?
*/

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
            queue.add((long) work);
        }
        
        int 남은_작업_시간 = n;
        
        // 작업이 비어있지 않을 때 까지 & 남은_작업_시간이 있을 떄까지 반복
        while(queue.peek() != null & 남은_작업_시간 > 0) {
            long 큰_작업량 = queue.poll();
            
            if(큰_작업량 >= 2) {
                queue.add(큰_작업량 - 1);
            }
            남은_작업_시간 --;
        }
        
        long 야근_지수 = 0;
        while(!queue.isEmpty()) {
            long 꺼낸_값= queue.poll();
            야근_지수 += 꺼낸_값 * 꺼낸_값;
        }
        
        return 야근_지수;
    }
}