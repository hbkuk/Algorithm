class Solution {
    // 절댓값, 부호가 순서대로 담긴 배열 전달
    // 정수들의 합을 구한 값을 return ...
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        
        for(int i = 0; i < absolutes.length; i++ ) {
            if(signs[i]) {
                sum += (absolutes[i]);
            }
            if(!signs[i]) {
                sum += (absolutes[i] * -1);
            }
        }
        return sum;
    }
}