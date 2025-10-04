import java.util.*;

class Solution {
    public int solution(String dartResult) {
        
        List<Point> 점수_목록 = new ArrayList<Point>();
        
        int 포인터 = 0;
        while(포인터 <= dartResult.length() -1 ) {
            
            char 문자 = dartResult.charAt(포인터);
            if(문자 == '*') {
                // 현재 점수 목록 모두 2배
                int 마지막 = 점수_목록.size() - 1;
                점수_목록.get(마지막).apply(2); // 현재 점수 2배
                if (마지막 - 1 >= 0) {
                    점수_목록.get(마지막 - 1).apply(2); // 이전 점수도 2배
                }
                포인터 ++;
            } else if (문자 == '#') {
                // 가장 최근 점수 목록에 -1 곱하기
                점수_목록.get(점수_목록.size() -1)
                    .apply(-1);
                포인터 ++;
            } else {
                // 새로운 점수를 적용할 시간이다!
                int 점수;
                if (문자 == '1' && dartResult.charAt(포인터 + 1) == '0') {
                    점수 = 10;
                    포인터 += 2; // 10은 두 자리니까
                } else {
                    점수 = 문자 - '0'; // 문자 '5' → 숫자 5
                    포인터++;
                }
                
                if (dartResult.charAt(포인터) == 'S') {
                    점수_목록.add(new Point((int)Math.pow(점수, 1)));
                } else if (dartResult.charAt(포인터) == 'D') {
                    점수_목록.add(new Point((int)Math.pow(점수, 2)));
                } else if (dartResult.charAt(포인터) == 'T') {
                    점수_목록.add(new Point((int)Math.pow(점수, 3)));
                }
                포인터++;
            }   
        }
        
        int 총_점수 = 0;
        for(Point 점수 : 점수_목록) {
            총_점수 += 점수.get점수();
        }
        
        return 총_점수;
    }
}

class Point {
    int 점수;
    
    Point(int 점수) {
        this.점수 = 점수;
    }
    
    int get점수() {
        return this.점수;
    }
    
    void apply(int 적용_숫자) {
        this.점수 = this.점수 * 적용_숫자;
    }
}