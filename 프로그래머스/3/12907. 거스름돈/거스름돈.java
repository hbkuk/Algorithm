/**
느낌이. DP로 푸는 것 같은데..
DP 로 어떻게 푸는지 까먺음.

**/

import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int dp[] = new int[n + 1]; // 0부터 N까지 값을 구한다.
        
        dp[0] = 1; // 0을 만드는 방법은 1이다.
        
        Arrays.sort(money); // 작은 숫자부터 조합을 한다.
        
        for(int coin : money ) {
            // 현재 단위부터 진행. 이전 단위는 어짜피 돌아도. 동일한 값임.
            for(int amount = coin; amount <= n; amount++) {
                // System.out.println("현재 coin --> " + coin);
                // System.out.println("만들려는 수 --> " + amount);
                dp[amount] = dp[amount] + dp[(amount - coin)] % 1000000007 ;
                // System.out.println("지금까지 mount 조합 수 --> " + dp[amount]);
                //dp[i] = dp[i] + dp[(n - i)] % 1000000007;
            }
        }
        
        return dp[n];
    }
}