import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int startIdx = commands[i][0] - 1;
            int endIdx = commands[i][1] - 1;
            int targetIdx = commands[i][2] - 1;

            int[] slicedArray = new int[endIdx - startIdx + 1];

            for(int j = 0; j < slicedArray.length; j++) {
                slicedArray[j] = array[startIdx + j];
            }
            
            Arrays.sort(slicedArray);
            answer[i] = slicedArray[targetIdx];
        }
        
        return answer;
    }
}