class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    
    // index: 현재 처리할 인덱스
    // currentSum: 현재까지의 값
    int dfs(int index, int currentSum, int[] numbers, int target) {
        int sum = 0;
        
        // 1. 종료 조건 확인
        if (index == numbers.length) {
            if (currentSum == target) {
                sum ++;
                return sum;
            }
            return sum;
        }
        
        // 2. 재귀 호출
        sum += dfs(index + 1, currentSum + numbers[index], numbers, target);
        sum += dfs(index + 1, currentSum - numbers[index], numbers, target);
        
        return sum;
    }
}