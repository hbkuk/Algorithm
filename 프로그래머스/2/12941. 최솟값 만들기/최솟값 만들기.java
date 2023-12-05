import java.util.*;

class Solution {
    // 두 배열에서 조합해서 최솟값을 만들어 return 하라..
    // 단순히 ... 가장 큰수와 가장 작은 수를 계속해서 곱하는게 맞는 것일까?
    // 우선... 가장 큰수와 가장 작은 수로 계속 찾아서 해보자..
    
    // 이거.. 느낌이 ... DP로 푸는 것 같은데 .. 어떻게 풀까?
    public int solution(int[] A, int[] B) {
        // 가장 작은수 탐색... N ..
        // 가장 큰수 탐색.. N ..
        // 1000 * 1000 =>
        
        Arrays.sort(A);
        Arrays.sort(B);
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            result += A[i] * B[A.length - 1 - i];
        }   
        return result;
    }
}