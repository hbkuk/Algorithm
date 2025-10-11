import java.util.*;

class Solution {
    
    // 1. t 문자열을 substring으로 p의 길이만큼 짜르면서 List에 저장한다.
    // 2. 1번에서 구한 값과 p를 Integer 타입으로 변환 후 비교하고, 작거나 같은 것에 대해서 카운팅한다.
    public int solution(String t, String p) {
        int answer = 0;
        
        int p_길이 = p.length() - 1;
        
        List<Long> 숫자_목록 = new ArrayList<>();
        int 포인터 = 0;
        while((포인터 + p_길이) <= (t.length() - 1)) {
            String 추가할_무자열 = t.substring(포인터, 포인터 + p_길이 + 1);
            숫자_목록.add(Long.parseLong(추가할_무자열));
            포인터 += 1;
        }
        
        long 기준_값 = Long.parseLong(p);
        
        for(long 대상_값 : 숫자_목록) {
            if(기준_값 >= 대상_값) {
                answer++;
            }
        }
        
        return answer;
    }
}