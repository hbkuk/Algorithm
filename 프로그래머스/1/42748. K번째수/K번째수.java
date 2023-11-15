import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // 결과 배열
        List<Integer> result = new ArrayList<>();
        
        for(int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int[] tempArray = Arrays.copyOfRange(array, i - 1, j);
            
            Arrays.sort(tempArray);
            
            result.add(tempArray[k - 1]);
        }
        
        // List를 int[] 변환
        return result.stream()
                    .mapToInt(Integer::intValue).toArray();
    }
}