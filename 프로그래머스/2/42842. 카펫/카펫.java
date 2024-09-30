class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 카펫의 격자 수
        
        for(int height = 3; height <= Math.sqrt(total); height++) {
            if(total % height == 0) {
                int width = total / height;
                
                if((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[0];
    }
}