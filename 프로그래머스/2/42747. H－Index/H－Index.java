// H-Index를 나타내는 값인 h 구하기
// 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용 => h의 최댓 값이 H-Index
class Solution {
    // 최댓값 h를 구하라!!!
    // 1. 전달받은 배열의 length을 h로 설정한다.
    // 2. 전달받은 배열에서 h번 이상 인용된 논문이 h편 이상인지 확인한다.
    //  - h 이상이라면
    //  => 정답
    //  - h 미만이라면
    //  => h -- 한 후, 2번으로 돌아간다.
    // ===> 최악의 시간복잡도는 10^6 이다. 이정도면 시간초과는 발생하지 않을 것으로 예상한다.
    // ===> 자! 이제 문제를 풀어보자.
    public int solution(int[] citations) {
        int h = citations.length;
        
        for(int i = 0; i < citations.length; i++) {
            int count = h;
            // 논문이 h번 이상, h편 이상인지 확인
            for(int j = 0; j < citations.length; j++) {
                if(citations[j] >= h) {
                    count --;
                }
                
                // 혹시 남은 citation을 다 해도, count를 지울 수 없다면 break
                if(count > citations.length - 1 - j) {
                    break;
                }
            }
            
            // 종료 조건
            if(count <= 0) {
                break;
            }
            h --;
        }
        return h;
    }
}