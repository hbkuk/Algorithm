import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); // 트럭이 지나가는 다리
        int time = 0; // 경과 시간
        int totalWeight = 0; // 다리 위 트럭 무게 합
        int truckIndex = 0; // 대기 중인 트럭의 인덱스
        int finishedCount = 0; // 다리를 지나간 트럭의 개수
        
        // 처음 다리를 빈 상태로 채움
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        while(finishedCount < truck_weights.length) {
            // 매 반복마다 시간 경과
            time ++;
            
            // 다리에서 트럭이 빠져나올 경우 무게 빼기
            int truckWeight = bridge.poll();
            if(truckWeight != 0) {
                finishedCount ++;
            }
            totalWeight -= truckWeight;
            
            // 대기 중인 트럭이 있을 경우
            if(truckIndex < truck_weights.length) {
                // 새로운 트럭을 추가할 수 있는 경우
                if(weight >= totalWeight + truck_weights[truckIndex]) {
                    bridge.offer(truck_weights[truckIndex]);
                    totalWeight += truck_weights[truckIndex];
                    truckIndex++;
                }

                // 트럭을 추가할 수 없는 경우
                else {
                    bridge.offer(0);
                }
            } else {
                bridge.offer(0);
            }
        }
        
        return time;
    }
}