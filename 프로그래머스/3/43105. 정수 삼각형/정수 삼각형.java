/**

문제: 거쳐간 숫자의 최댓값 구하가ㅣ.

접근 방식:
1. for문으로 거쳐간 경로를 저장해서 마지막에 합산 후 최댓값 갱신.
2. 각 층별로 최댓값 미리 갱신해서 활용하기. -> DP

세부 내용
1. 삼각형 꼭대기부터 마지막 줄 - 1 인 행까지 DP를 갱신해간다.
2. 마지막 줄에서 최댓 값을 찾아 반환한다.

예외 케이스
1. 삼각형 높이가 1일때 -> 최댓값 제대로 나오는지.
2. int 범위 넘어가는지? -> 10,000 * 100 * 5 ->  10^6 -> 십만단위임. 이슈없음.

시간 복잡도
1. 일반적으로 트리는 O(log N) -> 시간복잡도가 소요됨.

**/
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 가장 마지막 행의 배열의 크기가 제일 크기때문에 해당 크기만큼 생성. -> 비효율적인 저장 공간 존재
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length]; // 각 구간별 최댓값 갱신 
        
        // 초기값 설정
        dp[0][0] = triangle[0][0];
        answer = dp[0][0];
        
        // 마지막 전까지행에서 업데이트.
        for(int i = 0; i < triangle.length - 1; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                int current = triangle[i][j]; // 현재 값.
                
                // DP 값 갱신. -> 바로 아래 행 + 우측 대각선 행.
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i+1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }
        
        // 마지막 행에서 최댓 값 가져오기
        for(int i = 0; i < dp[0].length; i++) {
            int value = dp[dp.length - 1][i];
            
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
}