class Solution {
    public long solution(int a, int b) {     
        // 모든 정수의 합 구하기
        long sum = 0;
        for(int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            sum += i;
        }
        
        return sum;
    }
}