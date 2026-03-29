/**

1. 자료구조
    - 객실별 이용 가능 시간: List<Integer> 

2. 필요 method
    - int toMin(String minStr) -> 문자열 분("HH:MM")을 받아서 분으로 환산 후 반환.

3. 구현계획
    1) book_time 전체를 순회하면서 int 분으로 환산.
    2) 대실 시작 시간 기준으로 오름차순 정렬.
    3) 하나씩 방배정
        - 기존 객실에 이어서 방을 배정할 수 있음?
            -> 있음. -> 시간 갱신
            -> 없음. -> 객실 추가

**/

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Integer> rooms = new ArrayList<>();
        
        // int형 분으로 환산.
        int[][] bookTimes = new int[book_time.length][book_time[0].length];
        for(int i = 0; i <= book_time.length - 1; i++) {
            for(int j = 0; j <= book_time[0].length - 1; j++) {
                bookTimes[i][j] = toMin(book_time[i][j]);
            }
        }
        
        // 대실 시작 시간 기준으로 오름차순 정렬.
        Arrays.sort(bookTimes, (a, b) -> Integer.compare(a[0], b[0]));
        
        
        // 방배정.
        for(int[] bookTime : bookTimes) {
            int start = bookTime[0];
            int end = bookTime[1] + 10; // 청소 시간까지 더한 값.
            
            // 기존 객실 재사용 확인
            boolean booked = false;
            for(int i = 0; i <= rooms.size() - 1; i++) {
                int room = rooms.get(i);   
                
                // 배정 성공.
                if(start >= room) {
                    booked = true;
                    rooms.remove(i);
                    rooms.add(end);
                    break;
                }
            }
            
            // 재사용 못하는 경우 새로운 객실 추가
            if(!booked) {
                rooms.add(end);
            }
            
        }
        
        
        return rooms.size();
    }
    
    // "15:00" ->  90000 min.
    int toMin(String minStr) {
        String[] arr = minStr.split(":");
        
        return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
    }
}