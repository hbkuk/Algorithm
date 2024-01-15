// 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매
// 서로 다른 종류의 수를 최소화
// 예를 들어, [1, 3, 2, 5, 4, 5, 2, 3] 중 6개를 판매한다고 가정
// 1, 4를 제외한 여섯 개의 귤을 상자에 담으면 서로 다른 종류가 최소..
import java.util.*;
class Solution {
    // 1. 귤의 크기를 담은 배열을 정렬한다.
    // 2. 동일한 크기가 몇개인지, 배열에 저장한다.
    //  - 개수[1] = 3(귤의 크기가 1인 총 개수)
    //  - 개수[2] = 2(귤의 크기가 2인 총 개수)
    // 3. 한 상자에 다음려는 귤의 개수 k에 최대한으로 몇개를 담을 수 있을까?
    public int solution(int k, int[] tangerine) {
        // 정렬
        Arrays.sort(tangerine);
        
        // 몇개인지 담을 배열 선언
        int[] count = new int[tangerine[tangerine.length - 1] + 1];
        for(int value : tangerine) {
            count[value] ++;
        }
        
        // 제일 많은 것부터 k개 만큼 빼기
        int typeCount = 0;
        int lastIndex = count.length - 1;
        
        Arrays.sort(count);
        
        while(k > 0 && lastIndex >= 0) {
            k -= count[lastIndex--];
            
            typeCount ++;
        }
        
        return typeCount;
    }
}