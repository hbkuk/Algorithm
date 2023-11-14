import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int findIndex = 0;
        for(findIndex = 0; findIndex < completion.length; findIndex++ ) {
            if(!participant[findIndex].equals(completion[findIndex])) {
                break;
            }
        }
        
        return participant[findIndex];
        
    }
}