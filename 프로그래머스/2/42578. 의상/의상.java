/**
[문제]
- 종류가 뭐가되었든 최소 한 개의 의상을 착용해야한다.
- 의상 일부가 겹치더라도, 의상 조합이 다르기만 하면된다. 단!!!! 의상 순서가 다르다고 다른 조합이 아니다.
- 종류 별 최대 1가지 의상만!!!!

[예외 케이스]
- 아무런 의상이 주어지지 않는 경우 => 없음.
- 너무 많은 의상이 주어진 경우 => 최대 30개만.
- 다른 종류이나 같은 이름의 의상이 주어진 경우 => 없음.

[접근 방식]
- 의상 종류로 구분하는 것 => 가능. Map<의상 종류, 의상 목록> => Map<String,List<String>> 타입.
- 의상 종류 구분하고, 조합 숫자를 세는 것 => 어떻게?
    - A 종류에 2개. B 종류에 1개 => 5개.
    - A 종류에 3개             => 3개.
- 이 연관성은 어떻게 찾아야할까.. => 수학적으로 고민이 필요함.
    - A 종류에 2개. B 종류에 1개 -> A 타입 2개 중 하나를 선택하는 방법 + B 타입 1개 중 하나를 선택하는 방법 + A 타입과 B타입 중 각각 하나를 선택하는 방법..


**/
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> typeCountMap = new HashMap<>(); // 의상 종류 별 수량 카운트
        for(String[] arr : clothes) {
            String name = arr[0];
            String type = arr[1];
            // System.out.println(String.format("%s name | %s type -----> ", name, type));
            
            typeCountMap.put(type, typeCountMap.getOrDefault(type, 1) + 1); // 아무것도 안입는 케이스 고려해서 1로 설정.
            // System.out.println(String.format("%s type | %s count -----> ", type, typeCountMap.get(type)));
        }
        
        // 전체 순회하면서 조합 계산하기
        int result = 1;
        
        for(String type : typeCountMap.keySet()) {
            int count = typeCountMap.get(type);
            result *= count;
        }
        
        return result - 1; // 아무것도 종류도 안입는 조합 빼기
    }
}