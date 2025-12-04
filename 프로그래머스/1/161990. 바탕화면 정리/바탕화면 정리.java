class Solution {
    
    // 최소 직사각형 포인트 찾기
    // 1. 이중 for문
    //  - '#' (파일 있음)을 찾은 경우 드래그의 시작점과 끝점을 갱신한다.
    // 2. for문 종료 후 값을 리턴한다.
    public int[] solution(String[] wallpaper) {
        
        int lux = 50;
        int luy = 50;
        int rdx = 0;
        int rdy = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            char[] chars = wallpaper[i].toCharArray();
            for(int j = 0; j < chars.length; j++) {
                if(chars[j] == '#') {
                    lux = Math.min(lux, j);
                    luy = Math.min(luy, i);
                    
                    rdx = Math.max(rdx, j + 1);
                    rdy = Math.max(rdy, i + 1);
                }
            }
        }
        
        return new int[]{luy, lux, rdy, rdx};
    }
}