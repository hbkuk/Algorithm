class Solution {
    
    // a, z 가 int 로 몇인지 확인
    // 문자열 s를 배열로 쪼개기
    // 각 문자열을 순회해서 index 뒤의 문자 찾기.. -> 스킵 문자열 일경우 카운팅 X, 스킵 문자열에 포함되지 않을 경우 카운팅 +1..
    
    // 시간 복잡도는? O(N)  -> 50..
    public String solution(String s, String skip, int index) {
        
        // System.out.println((int) 'a'); // 97
        // System.out.println((int) 'z'); // 122
        
        StringBuilder answer = new StringBuilder();
        
        char[] chars = s.toCharArray(); // 알파벳 ...
        
        for(char c : chars) {
            int count = 0;
            char 찾은_문자 = c;
            while(true) {
                if(count == index) {
                    answer.append(찾은_문자);
                    break;
                }
                
                // 'a로 이동해야하는 경우'
                if(찾은_문자 == 'z') {
                    char 다음_문자 = 'a';
                    // 스킵에 포함되는지 확인
                    if(skip.indexOf(다음_문자) == -1) {
                        // 카운팅 후 다음_문자로 이동
                        count ++;
                        찾은_문자 = 다음_문자;
                    } else {
                        
                        // 카운팅 없이 다음_문자로 이동
                        찾은_문자 = 다음_문자;
                    }
                    
                // 그냥 넘어가도 되는 경우
                } else {
                    char 다음_문자 = (char) ((int) 찾은_문자 + 1);
                    if(skip.indexOf(다음_문자) == -1) {
                        // 카운팅 후 다음_문자로 이동
                        count ++;
                        찾은_문자 = 다음_문자;
                    } else {
                        
                        // 카운팅 없이 다음_문자로 이동
                        찾은_문자 = 다음_문자;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}

