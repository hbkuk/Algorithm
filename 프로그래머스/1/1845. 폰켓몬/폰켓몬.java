import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int choiceCount = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        while(choiceCount != set.size()) {
            if(choiceCount <= set.size()) {
                break;
            }
            choiceCount--;
        }

        return choiceCount;
    }
}