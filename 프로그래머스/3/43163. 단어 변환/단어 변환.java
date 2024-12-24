import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        // 1) begin에서 words 하나씩 변환 시도
        //  - 단, 한개의 알파벳만 다른 word로 변환 가능
        
        Queue<Element> queue = new LinkedList<>();
        
        for(int i = 0; i < words.length; i++) {
            int matchCount = 0;
            
            String[] o = begin.split(""); // 기존 word
            String t = words[i]; // 바꿀 word
            
            for(int j = 0; j < o.length; j++) {
                // 찾은 경우
                int index = t.indexOf(o[j]);
                if(index != -1 ) {
                    matchCount ++; // 매치 카운트 증가
                    t = t.substring(0, index) + t.substring(index + 1); // 새로운 문자열로 만들기
                }
            }                
            
            // 하나만 다를 경우
            // 2) 1에서 변경된 word를 words에서 하나씩 변환 시도
            //  - 방문 여부 저장
            if(matchCount == begin.length() - 1) {
                boolean[] visited = new boolean[words.length];
                visited[i] = true; // 방문표시
                queue.offer(new Element(words[i], visited, 1)); // 큐에 넣기
            }
        }
        
        int changeCount = Integer.MAX_VALUE;
        
        // 3) 1~2를 진행하면서, target과 동일한지 확인
        //  - target으로 변환이 불가능한 경우 0을 리턴
        
        // 큐에 비어있을 때 까지 진행
        while(!queue.isEmpty()) {
            Element current = queue.poll(); // 현재 값
            
            String currentWord = current.getWord(); // 현재 문자
            boolean[] pollVisited = current.getVisited(); // 방문 여부
            int count = current.getCount(); // 현재까지 바꾼 횟수
            
            // 현재 문자와 target 문자가 동일한 경우
            if(currentWord.equals(target)) {
                changeCount = Math.min(changeCount, count);
                continue;
            }
            
            for(int i = 0; i < words.length; i++) {
                // 해당 문자로 바꾼 적이 없을 경우
                if(!pollVisited[i]) {
                    
                    int matchCount = 0;
            
                    String[] o = currentWord.split(""); // 기존 word
                    String t = words[i]; // 바꿀 word

                    for(int j = 0; j < o.length; j++) {
                        // 찾은 경우
                        int index = t.indexOf(o[j]);
                        if(index != -1 ) {
                            matchCount ++; // 매치 카운트 증가
                            t = t.substring(0, index) + t.substring(index + 1); // 새로운 문자열로 만들기
                        }
                    }       

                    if(matchCount == begin.length() - 1) {
                        pollVisited[i] = true; // 방문표시
                        queue.offer(new Element(words[i], pollVisited, count + 1)); // 큐에 넣기
                    }
                } else {
                    continue;
                }
            }
            
        }
    
        
        if(changeCount == Integer.MAX_VALUE) {
            return 0;
        } else {
            return changeCount;
        }
    }
}

class Element {
    
    String word;
    boolean[] visited;
    int count;
    
    Element(String word, boolean[] visited, int count) {
        this.word = word;
        this.visited = visited;
        this.count = count;
    }
    
    String getWord() {
        return word;
    }
    
    boolean[] getVisited() {
        return visited;
    }
    
    int getCount() {
        return count;
    }
}