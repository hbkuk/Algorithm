/**

풀이방식:
1. 진도율이 100% 이상되는 일수를 계산한다.
2. 기준일을 잡고, 어느 작업까지 포함할 수 있는지 카운트를 센다.
3. 결과를 저장하고 반환한다.

예외 케이스:
1. 작업이 하나라도 주어지지 않았을 경우 -> 빈 배열 반환.
2. 작업의 진행률이 0 일 경우 -> 없음.
3. 작업의 속도가 0일 경우 -> 없음.


시간복잡도:
1. 일수를 계산하기 위한 작업 -> O(N) -> 작업의 개수는 100개 이하. -> 현재는 상수 시간만큼 소요될 것으로 예상.
2. 기준 일을 선정하고 작업 포함 여부 확인 -> 최악의 경우 O(N^2). -> 현재는 상수 시간만큼 소요될 것으로 예상.

**/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int[] days = new int[progresses.length]; // 필요한 일수 저장.
        for(int i = 0; i < progresses.length; i++) {
            int progress = progresses[i]; // 현재 진행률
            int speed = speeds[i]; // 현재 속도.
                
            int day = (100 - progress + speed - 1) / speed; // 필요한 일수.
            days[i] = day;
        }
        
        // 포인터를 옮기며 기준 일 선정.
        // 기준 일에 작업 포함 여부 확인
        int pointer = 0;
        int baseDay = days[pointer];
        int count = 0;
        
        // 포인터가 마지막까지 도달할때까지 반복.
        while(pointer < days.length) {
            
            // 미리 끝난 작업임. 배포 가능.
            if(baseDay >= days[pointer]) {
                pointer ++; // 포인터 옮기고.
                count ++;   // 배포 건수 증가.
            
            // 배포 불가능. base 작업만 가능.
            } else {
                answer.add(count);        // 지금까지의 배포를 확정
                baseDay = days[pointer]; // 기준일 다시 지정.
                count = 0;
            }
        }
        
        answer.add(count);
        
        
        return answer.stream().mapToInt(i ->i).toArray();
    }
}