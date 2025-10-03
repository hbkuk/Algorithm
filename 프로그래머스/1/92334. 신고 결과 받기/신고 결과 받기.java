import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Set<Integer>> 유저별_신고_유저 = new HashMap<>();        
        int[] 신고당한_횟수 = new int[id_list.length];
        
        Map<String, Integer> 이름_인덱스_변환_맵 = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            이름_인덱스_변환_맵.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] 값 = report[i].split(" ");
            
            String 신고한_사람 = 값[0];
            String 신고당한_사람 = 값[1];
            
            Set<Integer> 신고_목록 = 유저별_신고_유저.getOrDefault(신고한_사람, new HashSet());
            유저별_신고_유저.put(신고한_사람, 신고_목록);
            // 신고한 적 없는 경우
            int 신고당한_사람_인덱스 = 이름_인덱스_변환_맵.get(신고당한_사람);
            if(!신고_목록.contains((신고당한_사람_인덱스))) {
                신고_목록.add(신고당한_사람_인덱스);
                신고당한_횟수[신고당한_사람_인덱스] ++;
            }
        }
        
        List<Integer> 정지된_유저_인덱스_목록 = new ArrayList<>();
        for(int i = 0; i < 신고당한_횟수.length; i++) {
            if(k <= 신고당한_횟수[i]) {
                정지된_유저_인덱스_목록.add(i);
            }
        }
        
        int[] 메일_발송_횟수 = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            Set<Integer> 신고_목록 = 유저별_신고_유저.get(id_list[i]);
            if(신고_목록 == null) {
                continue;
            }
            
            for(int 인덱스 : 정지된_유저_인덱스_목록) {
                if(신고_목록.contains(인덱스)) {
                    메일_발송_횟수[i] ++;
                }
            }
        }

        return 메일_발송_횟수;
    }
}