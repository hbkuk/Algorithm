import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];
        
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String preWord = words[i - 1];
            String curWord = words[i];
            
            if (usedWords.contains(curWord) || preWord.charAt(preWord.length() - 1) != curWord.charAt(0)) {
                result[0] = (i % n) + 1;
                result[1] = (i / n) + 1;
                break;
            }
            
            usedWords.add(curWord);
        }
        
        return result;
    }
}
