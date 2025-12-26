import java.util.*;

class Solution {
    
    // 1. a부터 z까지 구간 int[] 생성
    // 2. int[]을 -1로 초기화한다.
    // 3. 문자열 s를 순회
    //  - 마지막 위치가 -1이 라면.. 현재 위치 갱신 후 .. 리스트에 -1을 추가한다.
    //  - 마지막 위치가 -1이 아니라면.. 현재 위치 갱신 후 .. 리스트에 현재 인덱스와의 차이 값을 추가한다.
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int 소문자_알파벳_길이 = (int) ('z' - 'a');
        int[] 거리_정보 = new int[소문자_알파벳_길이 + 1];
        
        Arrays.fill(거리_정보, -1);
        
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            
            // 이미 가까운 거리에 있는 경우
            if(거리_정보[c - 'a'] != -1) {
                answer[i] = i - 거리_정보[c- 'a'];
                
            // 없는 경우
            } else {
                answer[i] = -1;
            }
            
            거리_정보[c- 'a'] = i;
        }
        
        return answer;
    }
}