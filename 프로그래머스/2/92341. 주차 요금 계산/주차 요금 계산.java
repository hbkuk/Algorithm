/**

1. 데이터 저장 구조
    - 차량별 누적 주차 시간 관리 -> Map<차량번호,누적시간>
    - 차량별 입차 관리         -> Map<차량번호,입차시간>

2. 메서드 분리
    - int toMin(String data) -> 문자 시각을 받아서 분으로 반환
    - int calculate(int min) -> 분을 받아서 주차요금 반환

3. 구현 계획
    - records 순회
        - 입차 기록 -> 입차 관리 Map에 put
        - 누적 기록 -> 입차 관리 Map에서 꺼냄. 누적 주차 시간 Map에 넣음.
    - 입차 기록이 남아있는 것 별도 처리.
    - 누적 주차 시간을 기반으로 계산 후 리스트에 정리.
    - 리스트 차량번호 기반으로 오름차순 정렬

**/

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Integer> inMap = new HashMap<>();
        Map<String,Integer> resultMap = new HashMap<>();
        
        for(String record : records) {
            String[] s = record.split(" ");
            String min = s[0];
            String number = s[1];
            String type = s[2];
            
            // 입차인 경우 -> Map에 넣음.
            if(type.equals("IN")) {
                inMap.put(number, toMin(min));
            // 출차인 경우 -> 입차 관리에서 빼서 누적에 넣음.
            } else {
                int inMin = inMap.get(number);
                int outMin = toMin(min);
                
                // 기존 데이터가 있을 수 있음.
                resultMap.put(number, resultMap.getOrDefault(number, 0) + (outMin - inMin));
                
                // 계산 후 입차 기록에서 제외하기
                inMap.remove(number);
            }
        }
        
        // 입차 기록이 남아있는 것 별도 처리.
        for (String key : inMap.keySet()) {
            resultMap.put(key, resultMap.getOrDefault(key, 0) + (toMin("23:59") - inMap.get(key)));
        }
        
        // 누적 값 다 구했으니. 계산하고, 차량번호 기반으로 오름차순 정렬 후 금액만 반환.
        List<String> names = new ArrayList<>(resultMap.keySet());
        Collections.sort(names);
        
        
        List<Integer> result = new ArrayList<>();
        for(String name : names) {
            result.add(calculate(resultMap.get(name), fees));
        }
        
        // map -> 차량번호 기준으로 오름차순 정렬 후 청구액만 반환.
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    int toMin(String data) {
        String[] s = data.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    
    // 1. 기본 요금만 청구되는 케이스
    // 2. 기본 요금 + 단위 시간으로만 청구되는 케이스
    int calculate(int min, int[] fees) {
        int baseMin = fees[0]; // 기본 시간
        int basePrice = fees[1]; // 기본 요금
        int chargeMin = fees[2]; // 단위 시간
        int chargePrice = fees[3]; // 단위 요금
        
        int additionalMin = min - baseMin;
        
        int additionalTotal = 0;
        
        if(additionalMin > 0) {
            additionalTotal += (additionalMin / chargeMin) * chargePrice;
            if(additionalMin % chargeMin != 0)  {
                additionalTotal += chargePrice;
            }
        }
        
        return basePrice + additionalTotal;
    }
}