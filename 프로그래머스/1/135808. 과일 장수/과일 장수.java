import java.util.Arrays;
import java.util.Collections;

class Solution {
    
    // 1. score를 내림차순 정렬
    // 2. m개씩 담기..
    // 3. m개씩 담은 것 중에 최하점 * m -> 결과 추가
    public int solution(int k, int m, int[] score) {
        
        // int[] -> Integer[] 로 변환 후 내림차순 정렬
        Integer[] scores = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scores, Collections.reverseOrder());
        
        int 결과 = 0;
        
        
        // m개씩.. 증가시키기?
        int 현재_순번 = m - 1;
        while (scores.length - 1 >= 현재_순번) {
            
            int 합산 = scores[현재_순번] * m;
            
            결과 += 합산;
            
            현재_순번 += m;
        }
        
        
        return 결과;
    }
}