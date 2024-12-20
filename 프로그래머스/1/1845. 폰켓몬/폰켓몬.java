import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Solution {
    // 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리 선택
    public int solution(int[] nums) {
        // return => 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나
        
        // 구현 방법 1: 각 자리에 해당하는 숫자가 서로 다른숫자니?
        //  - 1) Set 자료구조로 변환
        //  - 2) N/2보다 큰지? 작은지?
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int size = set.size();
        if(size > nums.length/2) {
            return nums.length/2; 
        } else {
            return size;
        }
    }
}