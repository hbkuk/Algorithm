/**
[문제]
1. 최대한 구명보트 적게 사용하기.

[문제 접근 방식]
1. 몸무게를 오름차순 정렬.
2. 포인터를 사용해서 무게 제한 확인.
   - 리스트의 앞/뒤 포인터 1개
      - 포인터 뒤에있는 것을 하나씩 당기면서 확인.(종료조건: 두 포인터가 겹치는 시점)
**/

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        // rigth는 항상 커야함.
        while (left < right ) {
            
            // 둘다 태울 수 있는가? -> 가능
            if (people[left] + people[right] <= limit) {
                left ++;
                right --;
            
            // 둘다 태울 수 있는가? -> 불가능. 무거운 사람만 태우기.
            } else {
                right --;
            }

            // 보트 출발.
            boats++;
        }
        
        if(left == right) {
            boats ++;
        }
        
        return boats;
    }
}