class Solution {
    public int solution(int n) {
        int count = 0;
        for(int start = 1; start <= n; start++) {
            int sum = 0;
            int num = start;
            while(sum < n) {
                sum += num++;
                if(sum == n) {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
}