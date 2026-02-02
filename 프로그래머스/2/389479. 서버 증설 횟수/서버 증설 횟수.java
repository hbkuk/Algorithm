import java.util.*;

class Server {
    
    int endTime;
    
    Server(int endTime) {
        this.endTime = endTime;
    }
}

class Solution {
    
    // 1. 만약 (게임 이용자의 수 - (증설된 서버의 수 * m)) / m 각 시간마다 만큼 증설해줘야 함.
    // 2. 또한, k 시간이 지나는 경우 해당 서버는 종료처리 해야함.
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Server> queue = new LinkedList<>();
        
        for(int i = 0; i <= players.length - 1; i++ ) {
            
            while(!queue.isEmpty()) {
                Server s = queue.peek();

                // 종료시간과 맞지 않는 경우 반복문 종료
                if(s.endTime != i) {
                    break;
                }
                queue.poll();
            }
            
            int 현재_서버_수 = queue.size();
            int 현재_이용자_수 = players[i];
            
            if((현재_이용자_수 - (현재_서버_수 * m)) >= m) {
                
                int 증설_서버_수 = (현재_이용자_수 - (현재_서버_수 * m)) / m;
                for(int j = 1; j <= 증설_서버_수; j++) {
                    queue.offer(new Server(i + k));
                    answer ++;    
                }
            }
        }
        
        return answer;
    }
}