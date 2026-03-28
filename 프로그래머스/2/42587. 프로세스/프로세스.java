/**

<문제 분석>
1. 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번쨰로 실행되는지 알아내기

<접근 방식>
1. Task 클래스(int index, int priority) 를 모두 Queue에 넣는다.
2. Queue를 순회해서 가장 큰 값을 찾는다. 찾은 후 모든 Queue를 순차적으로 확인해서 맞는 값을 꺼낸다.
3. 해당 값이 찾는 index와 같다면 몇번쨰로 실행되었는지 return 한다.
**/

import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        Queue<Task> queue = new LinkedList<>();
        
        for(int i = 0; i <= priorities.length - 1; i++) {
            queue.add(new Task(i, priorities[i]));
        }
        
        int processCount = 1;
        // 찾을 때까지 반복.
        while(true) {
            
            // queue에서 가장 큰 숫자 찾기.
            int maxP = Integer.MIN_VALUE;
            for (Task task : queue) {
                maxP = Math.max(task.priority, maxP);
            }
            
            // 큐에 있는 값중 순차적으로 찾기
            while(true) {
                Task t = queue.poll();
                
                // 가장 큰 값을 찾음.
                if(t.priority == maxP) {
                    
                    // 알고 싶은 위치를 찾음.
                    if(t.index == location) {
                        return processCount;
                        
                    // 알고 싶은 위치가 아님
                    } else {
                        processCount ++;
                        break;
                    }
                // 찾지 못함.
                } else {
                    queue.add(t);
                }
            }
        }
    }
}

class Task {
    int index; 
    int priority;
    
    Task (int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}