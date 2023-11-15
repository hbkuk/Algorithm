import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            // 배열 자르기
            int[] tempArray = Arrays.copyOfRange(array, i - 1, j);
            
            // 정렬
            Arrays.sort(tempArray);

            // k번째 수 찾기
            result.add(tempArray[k - 1]);
        }

        // List를 int[] 배열로 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}