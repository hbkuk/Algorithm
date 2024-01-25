// 문제 풀이 계획
// 1. 투 포인터 활용
// - 1) start , end의 구간을 10개로 세팅
// - 2) want + number와 discount가 맞는지 확인
// 시간 복잡도
// - 최악의 경우) discount가 최대 10^5, want의 길이 10^1 => 10^6
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 초기 포인터 설정
        int start = 0;
        int end = 9;

        // 결과
        int result = 0;

        // want, number map 변환
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i <= want.length - 1; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 초기 10일에 dicsount를 품목 정리해보기
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i = 0; i <= 9; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        // while문 종료 시점 => end == discount.length -1
        while(end  <= discount.length - 1) {

            // 1. 등록 확인하기
            // - 배열 하나하나 꺼내서 확인
            boolean allProductsMatch = true;

            for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
                String wantKey = entry.getKey();
                int wantValue = entry.getValue();

                if (wantValue != discountMap.getOrDefault(wantKey, 0)) {
                    // 하나라도 일치하지 않는 경우
                    allProductsMatch = false;
                    break;
                }
            }

            // 모든 제품이 일치할 때만 result를 증가
            if (allProductsMatch) {
                result++;
            }

            // 2. dicsount 정리
            if(end + 1 <= discount.length - 1) {
                // 현재 start에 해당하는 상품을 discountMap에서 --
                // 현재 end에 해당하는 상품을 discountMap에서 --
                discountMap.put(discount[start], discountMap.get(discount[start]) - 1);
                discountMap.put(discount[end + 1], discountMap.getOrDefault(discount[end + 1], 0) + 1);
            }

            // 3. 포인터 이동, 포인터 넘치면 while문에서 break
            start ++;
            end ++;
        }

        return result;
    }
}