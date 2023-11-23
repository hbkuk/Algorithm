class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) {
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }

        // 최소 값 찾기
        int minNum = Integer.MAX_VALUE;
        int minNumPosition = 0;
        for(int i = 0; i < arr.length; i++) {
            if(minNum > arr[i]) {
                minNum = arr[i];
                minNumPosition = i;
            }
        }
        
        // 최소 값을 뺀 배열 반환하기
        int[] result = new int[arr.length - 1];
        int lastIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != minNum) {
                result[lastIndex] = arr[i];
                lastIndex ++;
            }
        }
        return result;
    }
}