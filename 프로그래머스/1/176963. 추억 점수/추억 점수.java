import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] 결과 = new int[photo.length];
        
        Map<String,Integer> 이름_점수_맵 = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            이름_점수_맵.put(name[i], yearning[i]);
        }
        
        
        for(int i = 0; i < photo.length; i++) {
            String[] 사진_속_이름 = photo[i];
            int 점수_합산 = 0;
            
            for(int j = 0; j < 사진_속_이름.length; j++) {
                Integer 점수 = 이름_점수_맵.get(사진_속_이름[j]);
                
                if(점수 == null) {
                    점수_합산 += 0;
                    continue;
                }
                점수_합산 += 점수;
            }
            
            
            결과[i] = 점수_합산; 
        }
        
        
        return 결과;
    }
}