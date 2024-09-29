import java.util.*;

class Solution {
    // 최소 힙 적용
    // 반복(모두 k 이상이 아닐 경우)
    //  - 가장 맵지 않은 음식 + (두번째 맵지 않은 음식 * 2)
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // pq에 담기
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int shakeCount = 0;
        while(true) {
            
            int lastItem = pq.peek();
            if(lastItem >= K) {
                break;
            }
            
            if(pq.size() >= 2) {
                int last1 = pq.poll();
                int last2 = pq.poll();
            
                pq.offer(last1 + (last2 * 2));
                shakeCount ++;
            } else {
                return -1;
            }
        }
        
        return shakeCount;
    }
}