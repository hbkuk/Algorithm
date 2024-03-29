import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int dividedCount = 0;
        boolean[] isDivided = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                isDivided[i] = true;
                dividedCount ++;
            }
        }
        if(isNotDivided(dividedCount)) {
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }
        int[] result = new int[dividedCount];
        int nextIndex = 0;
        
        for(int i = 0; i < isDivided.length; i++) {
            if(isDivided[i]) {
                result[nextIndex] = arr[i];
                nextIndex++;
            }
        }

        Arrays.sort(result);
        return result;
    }

    private static boolean isNotDivided(int dividedCount) {
        return dividedCount == 0;
    }
}