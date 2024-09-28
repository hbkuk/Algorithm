import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Boolean> i = new LinkedList<>();
        Queue<Integer> p = new LinkedList<>();
        
        for(int j = 0; j < priorities.length; j++) {
            i.offer(j == location);
            p.offer(priorities[j]);
        }
        
        int counting = 0;
        while(!p.isEmpty()) {
            for(int k = 9; k > 0; k--) {
                while(p.contains(k)) {
                    if(p.peek() == k) {
                        counting ++;
                        int item = p.poll();
                        boolean findItem = i.poll();
                        if(findItem) {
                            return counting;
                        }
                    } else {
                        int item = p.poll();
                        boolean findItem = i.poll();
                        p.add(item);
                        i.add(findItem);
                    }
                }
            }
        }
        return counting;
    }
}