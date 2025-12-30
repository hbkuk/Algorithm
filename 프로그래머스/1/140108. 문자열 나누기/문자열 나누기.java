class Solution {
    // x와 같은 수, x와 다른 수를 카운팅한다.
    // 같은 수와 다른 수가 같아지는 경우 문자열을 빼고 남은 부분에 대해서 반복한다.
    public int solution(String s) {
        int answer = 0;
        
        
        char[] chars = s.toCharArray();
        int currentIndex = 0;
        boolean 끝까지_확인 = false;
        
        while(!끝까지_확인 && currentIndex <= chars.length - 1) {
            int 같은_숫자_개수 = 0;
            int 다른_숫자_개수 = 0;
            
            char 기준_문자 = chars[currentIndex];
            boolean balanced = false;
            
            for(int i = currentIndex; i <= chars.length - 1; i++) {
                
                if(기준_문자 == chars[i]) {
                    같은_숫자_개수 ++;
                } else {
                    다른_숫자_개수 ++;
                }
                
                if(같은_숫자_개수 == 다른_숫자_개수) {
                    currentIndex = i + 1;
                    answer ++;
                    balanced = true;
                    break;
                }
            }
            
            // 끝까지 갔는데 균형이 안 맞았으면 남은 문자열도 하나로 처리
            if (!balanced) {
                answer++;
                break;
            }
            
            
        }
    
        return answer;
    }
}