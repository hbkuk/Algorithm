// 장르별로 가장 많이 재생된 노래를 두 개씩 모음.
//  1. 노래가 가장 많이 재생된 장르부터
//  2. 장르 내에서 많이 재생된 노래부터
//  3. 장르 내에서 재생 횟수가 같다면 고유 번호가 낮은 노래부터

// 1. genres 를 전체 순회하면서 총 몇회 재생되었는지 체크한다. -> 장르 우선순위, 간단한 Map 구조?
// 2. 장르 내에 우선 순위 체크한다.. -> 이건 어떻게 해야할까..?  Map에 리스트로 저장. 리스트 정렬은 Comparator 구현해서 진행.
// 3. 장르별로 리스트에 최대 2개씩 리스트에 담아서 배열로 반환.


import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genres_count = new HashMap<>(); // 장르별 총 재생 횟수
        Map<String, List<Integer>> genres_song = new HashMap<>(); // 장르별 노래 고유 번호
        
        for(int i = 0; i <= genres.length -1; i++) {
            String genre = genres[i]; // 장르.
            int play = plays[i]; // 재생 횟수
            
            // 저장 안되어있다면 추가, 저장되어있다면 수정. -> getOrDefault ?
            genres_count.put(genre, genres_count.getOrDefault(genre, 0) + play);
            List<Integer> list = genres_song.getOrDefault(genre, new ArrayList<>());
            genres_song.putIfAbsent(genre, list);
            list.add(i);
           
            // System.out.println("list -> " + list.size());
            // System.out.println("genres_count.get -> " + genres_count.get(genre));
        }
        
        // 전체 genres_song 의 list를 순회하면서 정렬한다.
        //    장르 내에서 많이 재생된 노래부터
        //    장르 내에서 재생 횟수가 같다면 고유 번호가 낮은 노래부터
        for (Map.Entry<String, List<Integer>> entry : genres_song.entrySet()) {
            // System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            
            List<Integer> list = entry.getValue();
            list.sort((a, b) -> {
                
                // 값이 같은지 확인
                //  - 같다면   -> 재생 횟수 많은 순이 먼저
                //  - 다르다면  -> 고유 번호 낮은 순이 먼저
                if(plays[a] == plays[b]) {
                    // System.out.println("값이 같음.. -> Integer.compare(a, b) --> " + Integer.compare(a, b));
                    return Integer.compare(a,b);
                }
                // System.out.println("값이 다름.. -> Integer.compare(plays[a], plays[b]) --> " + Integer.compare(plays[a], plays[b]));
                return Integer.compare(plays[b], plays[a]);
                
            });
        }
        
        List<Integer> result = new ArrayList<>(); // 결과 담을 목록.
        
        List<String> genreOrder = new ArrayList<>(genres_count.keySet()); // 장르별 재생 횟수 많은 오더.
        genreOrder.sort((a, b) -> { // 장르별 내림차순 정렬.
            return Integer.compare(genres_count.get(b), genres_count.get(a));
        });
        
        for (String genre : genreOrder) {
            List<Integer> list = genres_song.get(genre);
            
            // 전체 리스트 중 최대 두개만..
            int count = 1;
            for(int value : list) {
                if(count > 2) {
                    break;
                }
                result.add(value);
                count++;
            }
        }
        
        return result.stream()
                    .mapToInt(i -> i)
                    .toArray();
    }
}