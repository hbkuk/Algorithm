/**
[문제]
1. 속한 노래가 많이 재생된 장르부터
2. 장르 내 많이 재생된 노래부터
3. 장르 내 재생 횟수가 같은 노래 중 고유 번호가 낮은 노래부터 

[제한사항]
- 장르 내 곡은 최대 2개만. 1개만 선택될 수 있음.
- 장르의 재생 횟수는 모두 다름.

[풀이 방식]
1. 장르별 재생횟수 카운팅 -> Map, 내림차순 정렬 필요.
2. 장르 내 우선순위 정렬 -> List, 내림차순 정렬(많이 재생된 노래, 같다면 고유번호 낮은 순)
3. 1번에서 정렬된 List 기준으로 순회하면서 최대 2개씩 노래 선택.
4. 반환.
**/

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 재생횟수 카운팅 -> Map, 내림차순 정렬 필요.
        Map<String, Integer> genreCount = new HashMap<>(); // 장르별 카운트
        Map<String, List<Integer>> genreSong = new HashMap<>(); // 장르별 노래
        for(int i = 0; i <= genres.length - 1; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 카운팅 
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + play);
            
            // 장르별 리스트 추가
            List<Integer> list = genreSong.getOrDefault(genre, new ArrayList<>());
            list.add(i);
            genreSong.put(genre, list); 
        }
        
        // 2. 장르 내 우선순위 정렬 -> List, 내림차순 정렬(많이 재생된 노래, 같다면 고유번호 낮은 순)
        List<String> sortedCount = new ArrayList<>(genreCount.keySet());
        sortedCount.sort((a, b) -> {
            return Integer.compare(genreCount.get(b), genreCount.get(a));
        });
        // System.out.println(sortedCount);
        
        for(String genre : genreSong.keySet()) {
            List<Integer> list = genreSong.get(genre);
            list.sort((a, b) -> {
                if(plays[a] == plays[b]) {
                    return Integer.compare(a, b); // 고유번호 낮은 순
                }
                return Integer.compare(plays[b], plays[a]); // 재생횟수 많은 순
            });
        }
        
        List<Integer> result = new ArrayList<>();
        // 3. 1번에서 정렬된 List 기준으로 순회하면서 최대 2개씩 노래 선택.
        for(String genre : sortedCount) {
            List<Integer> list = genreSong.get(genre);
            for(int i = 0; i < Math.min(list.size(), 2); i++) {
                result.add(list.get(i));
            }
        }
        
        // 4. 반환.
        return result.stream().mapToInt(i -> i).toArray();
    }
}