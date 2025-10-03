import java.util.*;

class Solution {
    
    static int[] 점수_매핑 = {0, 3, 2, 1, 0, 1, 2, 3}; 
        
    public String solution(String[] survey, int[] choices) {
        
        int[][] 지표_그룹_점수 = new int[4][2]; // R|T C|F J|M A|N
        
        for(int i = 0; i < survey.length; i++) {
            String[] 분리된_값 = survey[i].split("");
            
            int 선택_값 = choices[i];
            
            if(선택_값 == 4) {
                continue;
            }
            
            String 유형 = null;
            if(선택_값 < 4) {
                유형 = 분리된_값[0];
            } else if(선택_값 > 4) {
                유형 = 분리된_값[1];
            }
            
            if(유형.equals("R")) {
                지표_그룹_점수[0][0] += 점수_매핑[선택_값];
            } else if (유형.equals("T")) {
                지표_그룹_점수[0][1] += 점수_매핑[선택_값];
            } else if (유형.equals("C")) {
                지표_그룹_점수[1][0] += 점수_매핑[선택_값];
            } else if (유형.equals("F")) {
                지표_그룹_점수[1][1] += 점수_매핑[선택_값];
            } else if (유형.equals("J")) {
                지표_그룹_점수[2][0] += 점수_매핑[선택_값];
            } else if (유형.equals("M")) {
                지표_그룹_점수[2][1] += 점수_매핑[선택_값];
            } else if (유형.equals("A")) {
                지표_그룹_점수[3][0] += 점수_매핑[선택_값];
            } else if (유형.equals("N")) {
                지표_그룹_점수[3][1] += 점수_매핑[선택_값];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(지표_그룹_점수[0][0] >= 지표_그룹_점수[0][1]) {
            sb.append("R");
        } else {
            sb.append("T");
        }
        if(지표_그룹_점수[1][0] >= 지표_그룹_점수[1][1]) {
            sb.append("C");
        } else {
            sb.append("F");
        }
        if(지표_그룹_점수[2][0] >= 지표_그룹_점수[2][1]) {
            sb.append("J");
        } else {
            sb.append("M");
        }
        if(지표_그룹_점수[3][0] >= 지표_그룹_점수[3][1]) {
            sb.append("A");
        } else {
            sb.append("N");
        }
        
        return sb.toString();
    }
}