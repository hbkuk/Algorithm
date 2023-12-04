import java.util.*;

class Solution {
    // 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬 후 새로운 문자 return 
    // 대문자는 소문자보다 작은 것으로 간주
    public String solution(String s) {
        // 1. 대문자와 소문자를 나누어서 StringBuilder에 담기
        // 2. StringBuilder를 String으로 변환 후 charArray로 변환
        // 3. Arrays.sort 메서드를 통해 정렬하기
        // 4. 소문자 + 대문자 String 합쳐서 반환하기
        
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c >= 'a' && c <= 'z') {
                lower.append(c);
            }
            if(c >= 'A' && c <= 'Z') {
                upper.append(c);
            }
        }
        
        char[] sortedLowerChars = lower.toString().toCharArray();
        char[] sortedUpperChars = upper.toString().toCharArray();
        
        Arrays.sort(sortedLowerChars);
        Arrays.sort(sortedUpperChars);
        
        StringBuilder sortedLower = new StringBuilder(new String(sortedLowerChars)).reverse();
        StringBuilder sortedUpper = new StringBuilder(new String(sortedUpperChars)).reverse();
            
        return sortedLower.toString() + sortedUpper.toString();
    }
}