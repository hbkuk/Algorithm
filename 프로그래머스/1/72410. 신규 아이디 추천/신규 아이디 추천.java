class Solution {
    
    // 1. toLowerCase(): 모든 대문자를 소문자로 치환
    // 2. new_id.replace("=", ""); // 문자 치환
    // 3. 마침표 2번 이상 반복되는 경우 하나로 변경 -> for 문으로 하나씩 확인해야겠는데?
    // 4. 마침표가 맨 앞/뒤에 있는 경우 제거 -> indexOf() 활용
    // 5. 빈 문자열인 경우 "a" 대입
    // 6. 문자열 길이가 16자 이상인 경우 -> 15자까지만, 혹시 맨뒤가 .인 경우 14자로..
    // 7. 문자열 길이가 2자 이하인 경우 -> 마지막 문자를 붙임.
    public String solution(String new_id) {
        
        // 1) 소문자_치환
        String 소문자_치환 = new_id.toLowerCase();
        System.out.println("1) 소문자_치환: " + 소문자_치환);
        
        // 2) 특수 문자 치환, -_.~!@#$%^&*()=+[{]}:?,<>/
        String 특수_문자_치환 = 소문자_치환.replaceAll("[^a-z0-9-_.]", "");
        System.out.println("2) 특수 문자 치환: " + 특수_문자_치환);
        
        // 3. 연속된 마침표 하나로 통합 -> pointer로 확인하기
        String 연속된_마침표_제거 = 특수_문자_치환.replaceAll("\\.+", ".");
        System.out.println("3. 연속된 마침표 하나로: " + 연속된_마침표_제거);
        
        // 4. 마침표가 맨 앞/뒤에 있는 경우 제거
        if(연속된_마침표_제거.charAt(0) == '.') {
            연속된_마침표_제거 = 연속된_마침표_제거.substring(1, 연속된_마침표_제거.length()); 
            System.out.println("마침표가 맨 앞/뒤에 있는 경우 제거 " + 연속된_마침표_제거);
        }
        
        if(연속된_마침표_제거.length() > 1 && 연속된_마침표_제거.charAt(연속된_마침표_제거.length() - 1) == '.') {
            연속된_마침표_제거 = 연속된_마침표_제거.substring(0, 연속된_마침표_제거.length() - 1); 
            System.out.println("마침표가 맨 앞/뒤에 있는 경우 제거 " + 연속된_마침표_제거);
        }
        
        // 5. 빈 문자열인 경우 "a" 대입
        if(연속된_마침표_제거.isEmpty()) {
            연속된_마침표_제거 = "a";
            System.out.println("빈 문자열인 경우 a 대입 " + 연속된_마침표_제거);
        }
        
        // 6. 문자열 길이가 16자 이상인 경우 -> 15자까지만, 혹시 맨뒤가 .인 경우 14자로..
        if(연속된_마침표_제거.length() >= 16) {
            
            연속된_마침표_제거 = 연속된_마침표_제거.substring(0, 15);
            System.out.println("15글자까지만 " + 연속된_마침표_제거);
            
            if(연속된_마침표_제거.charAt(연속된_마침표_제거.length() - 1) == '.') {
                연속된_마침표_제거 = 연속된_마침표_제거.substring(0, 연속된_마침표_제거.length() - 1); 
                System.out.println("마침표가 맨 앞/뒤에 있는 경우 제거 " + 연속된_마침표_제거);
            }
        }
        
        // 7. 문자열 길이가 2자 이하인 경우 -> 마지막 문자를 붙임.
        if(연속된_마침표_제거.length() <= 2) {
            char 마지막_문자 =연속된_마침표_제거.charAt(연속된_마침표_제거.length() -1);
            StringBuilder sb = new StringBuilder(연속된_마침표_제거);
            
            while(sb.length() < 3) {
                sb.append(마지막_문자);
            }
            
            연속된_마침표_제거 = sb.toString();
        }
        return 연속된_마침표_제거;
    }
}