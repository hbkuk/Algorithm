class Solution {
    // 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 배열 반환
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 배열의 크기 확인
        //  - arr1.length() => 행
        //  - arr1[i].length() => 열?
        int[][] result = new int[arr1.length][arr1[1].length];
        for(int i =0; i < result.length; i++) {
            for(int j =0; j < result[i].length; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
             }
        }

        return result;
    }
}