// 피보나치 수
// F(n) = F(n-1) + F(n-2)가 적용되는 수
class Solution {
    // 재귀 함수로 풀 경우, 최악의 시간복잡도는 O(2^n) => 10^8 보다 크므로, 안됨.
    // 따라서, Dynamic Programming으로 풀어야함.
    
    // 모든 배열에 숫자를 넣어두고, 인덱스로 꺼내기
    public int solution(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % 1234567;
        }
        
        return array[n];
    }
}