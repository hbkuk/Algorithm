class Solution {
    
    // 3가지 기능:
    //  - 10초 전으로 이동 (prev), 현재 위치가 10초 미만인 경우 0분 0초로 이동.
    //  - 10초 후로 이동  (next), 동영상의 남은 시간이 10초 미만일 경우 마지막 위치로 이동
    //  - 오프닝 건너뛰기, 자동으로 오프닝이 끝나는 위치로 이동
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int 현재_초 = 0;
        
        int 비디오_처음_위치 = 0;
        int 비디오_종료_위치 = getSeconds(video_len);
        
        // 1) pos 확인
        //  - 오프닝 위치인 경우, 오프닝 끝나는 위치로 이동
        int 최초_위치 = getSeconds(pos);
        현재_초 = 최초_위치;
        
        int 오프닝_시작_위치 = getSeconds(op_start);
        int 오프닝_종료_위치 = getSeconds(op_end);
        
        // 최초 위치가 오프닝 시작과 종료 위치 사이에 있는 경우
        if(최초_위치 >= 오프닝_시작_위치 && 최초_위치 <= 오프닝_종료_위치) {
            현재_초 = 오프닝_종료_위치;
        }
        
        // 2) commands 순회
        //  (1) prev 인 경우
        //      - 10초 전으로 이동
        //          단, 00:00 보다 작은 숫자로 이동될 순 없다.
        //  (2) next 인 경우
        //      - 10초 후로 이동
        //          단, 동영상 길이인(video_len) 보다 큰 숫자로 이동될 순 없다.
        for(String command : commands) {
            
            if (command.equals("prev")) {
                int 이동될_위치 = 현재_초 - 10;
                현재_초 = Math.max(이동될_위치, 비디오_처음_위치);
            }
            
            if (command.equals("next")) {
                int 이동될_위치 = 현재_초 + 10;
                현재_초 = Math.min(이동될_위치, 비디오_종료_위치);
            }
            
            if(현재_초 >= 오프닝_시작_위치 && 현재_초 <= 오프닝_종료_위치) {
                현재_초 = 오프닝_종료_위치;
            }
        }
        
        
        return getTimeString(현재_초);
    }
    
    public int getSeconds(String value) {
        String[] values = value.split(":");
        return (Integer.parseInt(values[0]) * 60) + Integer.parseInt(values[1]);
    }
    
    public String getTimeString(int value) {
        int 분 = value / 60;
        String 분_문자열 = String.valueOf(분);
        if(분_문자열.length() != 2) {
            분_문자열 = "0" + 분_문자열;
        }
        
        int 초 = value % 60;
        String 초_문자열 = String.valueOf(초);
        if(초_문자열.length() != 2) {
            초_문자열 = "0" + 초_문자열;
        }
        
        return 분_문자열 + ":" + 초_문자열;
    }
}