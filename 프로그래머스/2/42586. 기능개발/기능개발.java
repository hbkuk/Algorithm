/**

<문제 정리>
1. 기능 개선 작업 수행 중. -> 각 기능은 100% 일 때 서비스에 반영.
2. 각 기능의 개발속도는 다름. 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 뒤에 있는 기능은 앞에 있ㄱ는 기능이 배포될때 함께 배포.

<접근 방식>
1. 우선 큐에 모든 작업을 넣는다.
2. 하루 치마다 개발 속도 만큼 작업량을 갱신한다.
3. 최초 작업이 100%인지 확인한다. -> 그 뒤에 있는 작업들도 100%이면 같이 배포한다.
4. 이 작업을 큐에 모든 작업이 없어질 때 까지 진행한다.
**/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        List<Task> tasks = new ArrayList<>();
        
        // 1. 모든 Task 넣기
        for(int i = 0; i <= progresses.length -1; i++) {
            tasks.add(new Task(progresses[i], speeds[i]));
        }
        
        
        while(!tasks.isEmpty()) {
            // 2. 작업량 갱신하기
            for(Task task : tasks) {
                task.process();
            }    
            
            // 3. 최초 작업이 100%인지 확인한다. -> 그 뒤에 있는 작업들도 100%이면 같이 배포한다.
            int doneTask = 0;
            for(Task task : tasks) {
                
                // 작업이 완료된 태스크가 있는 경우.
                if(task.isFinised()) {
                    doneTask += 1;
                    
                // 작업이 완료된 태스트가 없는 경우.
                } else {
                    break;    
                }
            }
            
            if(doneTask != 0) {
                result.add(doneTask);
            }
            
            for(int i = 0; i < doneTask; i++) {
                tasks.remove(0);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}

class Task {
    int progress;
    int speed;
    
    Task (int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
    
    void process() {
        this.progress += speed;
    }
    
    boolean isFinised() {
        return this.progress >= 100;
    }
}
