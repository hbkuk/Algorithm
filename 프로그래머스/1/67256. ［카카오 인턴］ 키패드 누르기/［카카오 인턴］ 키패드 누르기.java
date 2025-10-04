import java.util.*;

class Solution {
    
    static int[][] 번호_목록 = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9},
    {10, 0, 11}
    };
    
    public String solution(int[] numbers, String hand) {
        
        StringBuilder 정답 = new StringBuilder();
        
        cordinate 왼손_마지막 = getCordinate(10);
        cordinate 오른손_마지막 = getCordinate(11);
        
        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                정답.append("L");
                왼손_마지막 = getCordinate(num);
            } else if(num == 3 || num == 6 || num == 9) {
                정답.append("R");
                오른손_마지막 = getCordinate(num);
            } else {
                cordinate 타겟_좌표 = getCordinate(num);
                int 타겟_x_좌표 = 타겟_좌표.getX();
                int 타겟_y_좌표 = 타겟_좌표.getY();
                
                // 왼손 마지막에서 타겟까지의 거리
                int 왼손_x_좌표 = 왼손_마지막.getX();
                int 왼손_y_좌표 = 왼손_마지막.getY();
                
                int 왼손_거리 = Math.abs(타겟_x_좌표 - 왼손_x_좌표) + Math.abs(타겟_y_좌표 - 왼손_y_좌표); 
                
                // 오른손 마지막에서 타겟까지의 거리 차
                int 오른손_x_좌표 = 오른손_마지막.getX();
                int 오른손_y_좌표 = 오른손_마지막.getY();
                
                int 오른손_거리 = Math.abs(타겟_x_좌표 - 오른손_x_좌표) + Math.abs(타겟_y_좌표 - 오른손_y_좌표); 
                
                if(왼손_거리 < 오른손_거리) {
                    정답.append("L");
                    왼손_마지막 = getCordinate(num);
                } else if (왼손_거리 > 오른손_거리) {
                    정답.append("R");
                    오른손_마지막 = getCordinate(num);
                } else {
                    if(hand.equals("left")) {
                        정답.append("L");
                        왼손_마지막 = getCordinate(num);
                    } else {
                        정답.append("R");
                        오른손_마지막 = getCordinate(num);
                    }
                }
                
            }
        }
        
        return 정답.toString();
    }
    
    public cordinate getCordinate(int number) {
        if(number == 1) {
            return new cordinate(0, 0);
        }
        if(number == 2) {
            return new cordinate(1, 0);
        }
        if(number == 3) {
            return new cordinate(2,0);
        }
        if(number == 4) {
            return new cordinate(0,1);
        }
        if(number == 5) {
            return new cordinate(1, 1);
        }
        if(number == 6) {
            return new cordinate(2,1);
        }
        if(number == 7) {
            return new cordinate(0,2);
        }
        if(number == 8) {
            return new cordinate(1,2);
        }
        if(number == 9) {
            return new cordinate(2, 2);
        }
        if(number == 10) {
            return new cordinate(0,3);
        }
        if(number == 0) {
            return new cordinate(1,3);
        }
        if(number == 11) {
            return new cordinate(2,3);
        }
        return null;
    }
    
}

class cordinate {
    public int x;
    public int y;
    
    cordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getX() {
        return x;
    }
    
    int getY() {
        return y;
    }
}