/**

<문제 분석>

* H-Index는?: 논문 n 편 중, h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었다면 h의 최댓값

<접근 방식>
1. 내림차순 정렬
    - [3, 0, 6, 1, 5]	-> [6, 5, 3, 1, 0]
2. 가장 큰 숫자부터 확인
    - 6
        - (6편 이상 인용된 논문이 6편 이상) && (나머지 논문도 6번 이하 인용)
    - ...
    - 최소 0보다 작을 수 없음.
    
<성능 확인>
N * N => O(N) -> 10^6

**/

import java.util.*;
class Solution {
    public int solution(int[] citations) {
        // int[] -> Integer [] (정렬시 필수)
        Integer[] temp = Arrays.stream(citations)
            .boxed()
            .toArray(Integer[]::new);
        
        // 내림차순 정렬
        Arrays.sort(temp, Collections.reverseOrder());
        
        // 가장 큰 숫자부터 찾기.
        int h = temp.length;
        
        for(int i = 0; i <= temp.length - 1; i++) {
            
            // 기준으로 잡은 h가 길이보다 크다면
            if(h > temp.length) {
                h --;
                continue;
            }
            
            // 기준과 실제 배열에 있는 값이 동일하다면
            if(temp[h - 1] >= h) {
                return h;
            } else {
                h --;
                continue;
            }
        }
        
        return 0;
    }
}