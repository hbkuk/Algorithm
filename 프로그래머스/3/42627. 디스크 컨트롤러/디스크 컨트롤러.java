import java.util.*;

class Solution {
    // 우선 순위 큐를 만들어서, 작업 소요시간이 짧은 작업을 골라서 진행한다. => 최소 힙
    public int solution(int[][] jobs) {
        // jobs 배열을 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 작업 소요시간 오름차순
        
        int jobCount = jobs.length; // 작업 수량
        int completeJobs = 0; // 완료한 작업 수량
        int currentTime = 0; // 현재 시간
        int totalTime = 0;   // 작업 총 시간(대기 ~ 완료)
        int idx = 0; // 처리할 마지막 인덱스
        
        // 모든 작업이 완료될 때 까지 진행
        while(completeJobs < jobCount) {
            
            // 현재 시점에서 처리 가능한 모든 작업을 큐에 넣음
            while(idx < jobCount && currentTime >= jobs[idx][0]) {
                pq.offer(jobs[idx]);
                idx ++;
            }
            
            // 처리할 수 있는 작업이 있는지 확인
            if(!pq.isEmpty()) {
                int[] pollJob = pq.poll(); // 꺼내기
                completeJobs ++;           // 완료 처리
                currentTime += pollJob[1];   // 현재 시간 증가
                totalTime += (currentTime - pollJob[0]);   // 요청 시간부터 - 완료까지 시간 증가
            } else {
                // 처리할 일이 없을 경우 => 시간 흘려보내기
                currentTime = jobs[idx][0];
            }
        }
        
        return totalTime / jobCount;
    }
}