import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. 오름차순 정렬
        Arrays.sort(people);
        
        // 2. 보트에는 최대 2명이니 -> (몸무게 작은 분 & 몸무게 가장 큰 분 )을 보트에 태우기
        int boatCount = 0;
        int left = 0;
        int right = people.length - 1;
        
        while(true) {
            // 3. 커서가 오버될 경우 종료
            if(left > right) {
                break;
            }
            
            // 3. 보트에 태우기
            int boat = 0;
            boat += people[left];
            boat += people[right];
            
            // 보트에 태울 수 없는 경우
            if(boat > limit) {
                right --; 
            // 보트가 출발해도 되는 경우
            } else {
                left ++;
                right --; 
            }
            
            boatCount++;
        }
        
        
        return boatCount;
    }
}