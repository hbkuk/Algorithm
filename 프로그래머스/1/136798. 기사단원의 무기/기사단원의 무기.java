class Solution {
    
    // 1. 1부터 number까지.. for문을 나누기
    public int solution(int number, int limit, int power) {
        int 답 = 0;
        
        int[] 무기_공격력 = new int[number + 1];
        
        for(int i = 1; i <= number; i++) {
            
            int 약수_개수 = 0;
            int 현재_숫자 = i;
            for(int j = 1; j * j <= 현재_숫자; j++) {
                if (i % j == 0) {
                    약수_개수 += (j * j == 현재_숫자) ? 1 : 2;
                }
            }
            
            
            if(약수_개수 > limit) {
                답 += power;
            } else {
                답 += 약수_개수;
            }
        }
        return 답;
    }
}