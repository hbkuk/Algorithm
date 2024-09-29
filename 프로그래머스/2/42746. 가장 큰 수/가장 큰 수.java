import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // 문자열 추가하기
        String[] answer = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = String.valueOf(numbers[i]);
        }
        
        // 문자열 정렬하기
        Arrays.sort(answer, (a, b) -> (b + a).compareTo(a + b));
        
        if (answer[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : answer) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}