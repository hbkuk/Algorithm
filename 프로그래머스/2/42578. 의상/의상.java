// 문제 분석)
// 매일 다른 옷을 입어야 할 때, 조합의 수 return
// 종류별 1개의 옷만 가능
// 종류가 일부 겹치더라도, 다른 의상이 겹치지 않으면 + 1
// 종류가 일부 겹치더라도, 의상을 추가로 착용하면 + 1
// 하루에 최소 한 개 이상은 입어야 함.

// 문제 최종목표 
// 종류 별 숫자가 있을 때, 순서를 고려해서 최소 1개를 선택해서 조합한다면?

// 문제 접근방식
// 1. 종류를 구분한다.
//  - 얼굴, 상의, 하위 등..
// 2. 그렇다면, 최소 1개 선택을 하고 종류 수까지 선택하는 조합의 수를 구한다.
//  - 
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
    
        // 1. clothes를 순회하면서, Map에 담는다.
        Map<String, Integer> clothesMap = new HashMap<>();
        for(String[] cloth : clothes)  {
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        int combinationCount = 1;
        for (int count : clothesMap.values()) {
            combinationCount *= (count + 1); // 해당 종류의 의상을 선택하지 않는 경우까지 포함하여 곱셈
        }
            
        return combinationCount - 1;
    }
}