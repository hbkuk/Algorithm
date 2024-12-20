import java.util.*;

class Solution {
    // <최종 목표>
    // 각 장르 별로 많이 재생된 노래를 두 개씩 모으기
    // <기준>
    //  1. 속한 노래가 많이 재생된 장르
    //  2. 장르 내에서 많이 재생된 노래
    //  3. 장르 내에서 재생 횟수가 같으면, 고유 번호가 낮은 노래
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르 재생 횟수 저장 => key: 장르명, value: 재생 횟수
        Map<String, Integer> 총_장르_재생_횟수_map = new HashMap<>();
        
        // 2. 장르 별 재생 횟수 저장 => key: 장르명, value: List<Song>(고유번호, 재생 횟수)
        Map<String, List<Song>> 장르_map = new HashMap<>();        
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i]; // 장르명
            int playCount = plays[i]; // 재생 횟수
            
            총_장르_재생_횟수_map.put(genre, 총_장르_재생_횟수_map.getOrDefault(genre, 0) + playCount);
            
            List<Song> 기존_목록 = 장르_map.get(genre);
            if(기존_목록 == null) {
                List<Song> list = new ArrayList<>();
                list.add(new Song(i, playCount));
                
                장르_map.put(genre, list);
            } else {
                기존_목록.add(new Song(i, playCount));
            }
        }
            
        // 1. 총_장르_재생_횟수_map에서 내림차순으로 정렬 필요.
        List<Map.Entry<String, Integer>> 정렬된_장르_목록 = new ArrayList<>(총_장르_재생_횟수_map.entrySet());
        정렬된_장르_목록.sort((a, b) -> b.getValue() - a.getValue());

        
        // 2. 정렬한 후 장르별 재생 횟수에서 -> 재생 횟수 기준 내림차순 정렬 + 고유번호 오름차순 정렬
        for(Map.Entry<String, List<Song>> entry : 장르_map.entrySet()) {
            List<Song> 노래목록 = entry.getValue();
            노래목록.sort((a, b) -> {
               if(b.getPlayCount() != a.getPlayCount())  {
                   return b.getPlayCount() - a.getPlayCount(); // 재생 횟수 내림차순
               }
                return a.getId() - b.getId(); // 고유 번호 오름차순
            });
        }
        
        List<Integer> 베스트_앨범 = new ArrayList<>();
        
        // 3. 각 장르별 곡 2개씩를 베스트 앨범에 추가(1개일 경우 1개만)
        for(Map.Entry<String, Integer> 장르 : 정렬된_장르_목록) {
            String genre = 장르.getKey();
            List<Song> 노래_목록 = 장르_map.get(genre);
            
            for(int i = 0; i < Math.min(2, 노래_목록.size()); i++) {
                베스트_앨범.add(노래_목록.get(i).getId());
            }
        }
        
        // 4. 고유번호를 배열로 반환
        int[] answer = new int[베스트_앨범.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = 베스트_앨범.get(i);
        }
        return answer;
    } 
}

class Song {
    int id;
    int playCount;
    
    Song(int id, int playCount) {
        this.id = id;
        this.playCount = playCount;
    }
    
    int getId() {
        return this.id;
    }
    int getPlayCount() {
        return this.playCount;
    }
}