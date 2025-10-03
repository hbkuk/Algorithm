import java.util.*;

class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {

        // [주의 사항]
        // * 모든 달은 28일까지만 있음.
        // * 유효기간이 지났다면 반드시 파기
        // * 보관할 수 있는 달은 1이상 100 이하
        //  - 연도 계산 필수적...
        //      - 일을 28 로 나눈 나머지, 일을 28 로 나눈 몫
        //      - 월을 12 로 나눈 나머지, 월을 12 로 나눈 몫
        
        // [풀이 방식]
        //  1. terms Map을 만들어서 유효기간 관리하기
        //  2. privacies 와 동일하게 보관 최종일자를 관리하기
        //  3. 현재 날짜 이후로 보관일자가 지난 번호 추출하기
        
        List<Integer> 답 = new ArrayList<>();
        
        Map<String, Integer> 유효기간_맵 = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] 분리된_값 = terms[i].split(" ");
            
            유효기간_맵.put(분리된_값[0], Integer.parseInt(분리된_값[1]));
        }
        
        int 현재_날짜_값 = dateToDays(today);
        
        for(int i = 0; i < privacies.length; i++) {
            String[] 분리된_개인정보_수집_정보 = privacies[i].split(" ");
            
            String 수집_일자 = 분리된_개인정보_수집_정보[0];
            String 약관_종류 = 분리된_개인정보_수집_정보[1];
            
            // 수집_일자 + 유효기간 => 보관일자
            int 수집_일자_값 = dateToDays(수집_일자);
            int 유효기간_값 = 유효기간_맵.get(약관_종류) * 28;
            int 보관_일자_값 = 수집_일자_값 + 유효기간_값 - 1;
            
            if (현재_날짜_값 > 보관_일자_값) {
                답.add(i + 1);
            }
        }
        
        return 답.stream()
            .mapToInt(Integer::intValue)
            .toArray(); 
        }
    
    int dateToDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        return year * 12 * 28 + month * 28 + day;
    }
}