import java.util.*;
/* 
    1. 선수 이름이 불릴 경우 앞에 있는 선수와 자리를 바꾼다.
        - 1,000,000 번 반복하면 된다.
*/
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> 이름_인덱스_맵 = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            이름_인덱스_맵.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            String 추월한_사람_이름 = callings[i];
            int 추월한_사람_인덱스 = 이름_인덱스_맵.get(추월한_사람_이름);
            
            int 추월_당한_사람_인덱스 = 추월한_사람_인덱스 - 1;
            String 추월_당한_사람_이름 = players[추월_당한_사람_인덱스];
             
            // 이름_인덱스_맵 교환
            이름_인덱스_맵.put(추월한_사람_이름, 추월한_사람_인덱스 - 1);
            이름_인덱스_맵.put(players[추월_당한_사람_인덱스], 추월한_사람_인덱스);
            
            // players 교환
            players[추월한_사람_인덱스] = 추월_당한_사람_이름;
            players[추월_당한_사람_인덱스] = 추월한_사람_이름;
        }
        
        return players;
    }   
}
    