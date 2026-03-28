/**

// 한달을 28일로 기준을 잡고 진행한다.
// 별도 라이브러리는 사용할 수 없다. -> 모든 날짜를 일수로 계산해서 진행한다.

1. 필요 메서드
    int toLocalDate (String s) -> 문자열 년/월/일을 받아서 반환한다.
    int getSaveDate (int day, int plusMonth) -> 현재 날짜와 유효기간 월을 전달받아서 보관 가능한 일자를 반환한다.
     
2. 자료 구조
    문서 최대 보존기간 -> List

3. 구현 계획
    - 각 privacies를 순회하면서 마지막 보관날짜를 List에 담는다.
    - 오늘 날짜를 비교하면서 폐기해야할 문서의 인덱스를 담는다.
    - 반환한다.

**/

import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        for(String term : terms) {
            String[] arr = term.split(" ");
            termsMap.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        for(String privacy: privacies) {
            String[] arr = privacy.split(" ");
            
            list.add(getSaveDate(toDay(arr[0]), termsMap.get(arr[1])));
        }
        
        List<Integer> result = new ArrayList<>();
        
        int toDay = toDay(today);
        
        for(int i = 0; i <= list.size() - 1; i++) {
            if(toDay > list.get(i)) {
                result.add(i + 1);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    int toDay (String s) {
        String[] arr = s.split("\\.");
        
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        
        return (year * 12 * 28) + (month * 28) + (day);
    }
    
    int getSaveDate (int day, int plusMonth) {
        return day + (plusMonth * 28) - 1;
    }
}