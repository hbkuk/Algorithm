/**
[문제]
- begin, target과 단어의 집합인 words 주어짐.
- 가장 짧은 begin -> target 과정 찾기.
- 한 번의 한 개의 알페밧만 변경 가능.
- words에 있는 단어로만 변환 가능.

[접근 방식]
- 2중 For문으로 전체 조회..? -> for문의 for문의 for문의 for문.. 지옥이지 않을 듯?
- 가장 짧은 단어다보니 BFS로 하면 될듯?
-  for문으로 큐에넣기. 방문체크하기.

**/

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        
        Queue<Item> queue = new LinkedList<>();
        for(int i = 0; i < words.length; i++) {
            
            String word = words[i];
            // 전체 알파벳을 카운팅하고.. 전체 순회했을때 1만 남은게 1개일 경우에만 넣어야함.
            int diffCount = 0;
            for(int j = 0; j < word.length(); j++) {
                if(word.charAt(j) != begin.charAt(j)) {
                    diffCount ++;
                }
            }
            
            if(diffCount == 1) {
                visited[i] = true; // 방문 처리.
                queue.add(new Item(i, 1)); // 현재 인덱스 넣기.
                System.out.println("최초에 넣은 단어 --> " + word);
            }
        }
        
        // 큐 비어있지 않을 때 까지 계속 진행.
        while(!queue.isEmpty()) {
            
            Item item = queue.poll();  // 큐에서 빼기
            String currentWord = words[item.index];
            
            // 현재 단어가 찾는 단어일 경우 현재까지 변환 카운트 반환.
            if(currentWord.equals(target)) {
                return item.count;
            }
            
            // 아니라면 다시 쭉 돌기.
            for(int i = 0; i < words.length; i++) {
                
                // 현재 자기 차례면 넘김.
                if(i == item.index || visited[i]) {
                    continue;
                }
                
                String word = words[i];
                
                int diffCount = 0;
                for(int j = 0; j < word.length(); j++) {
                    if(word.charAt(j) != currentWord.charAt(j)) {
                        diffCount ++;
                    }
                }
            
                if(diffCount == 1) {
                   visited[i] = true; // 방문 처리.
                   queue.add(new Item(i, item.count + 1)); // 현재 인덱스 넣기.
                   System.out.println("최초에 넣은 단어 --> " + word);
                }
            }
        }        
        return answer;
    }
}

class Item {
    int index; // 
    int count; // 현재 변환 카운트.
    
    Item(int index, int count) {
        this.index = index;
        this.count = count;
    }
}