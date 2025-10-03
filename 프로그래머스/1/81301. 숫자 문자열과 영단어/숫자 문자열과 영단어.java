import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
    
        int pointer = 0;
        while(pointer <= s.length() -1) {
            // 숫자니?
            if((int) s.charAt(pointer) >= 48 && (int) s.charAt(pointer) <= 57) {
                sb.append(s.charAt(pointer));
                pointer += 1;
            // 문자니?
            } else {             
                String 자른_문자 = s.substring(pointer, s.length());
                if(자른_문자.startsWith("zero")) {
                    sb.append("0");
                    pointer += 3; 
                } else
                if(자른_문자.startsWith("one")) {
                    sb.append("1");
                    pointer += 2; 
                } else
                if(자른_문자.startsWith("two")) {
                    sb.append("2");
                    pointer += 2;
                } else
                if(자른_문자.startsWith("three")) {
                    sb.append("3");
                    pointer += 4;
                } else
                if(자른_문자.startsWith("four")) {
                    sb.append("4");
                    pointer += 3;
                } else
                if(자른_문자.startsWith("five")) {
                    sb.append("5");
                    pointer += 3;
                } else
                if(자른_문자.startsWith("six")) {
                    sb.append("6");
                    pointer += 2;
                } else
                if(자른_문자.startsWith("seven")) {
                    sb.append("7");
                    pointer += 4;
                } else
                if(자른_문자.startsWith("eight")) {
                    sb.append("8");
                    pointer += 4;
                } else
                if(자른_문자.startsWith("nine")) {
                    sb.append("9");
                    pointer += 3;
                }
                
            pointer += 1;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}