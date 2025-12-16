class Solution {
    
    // 카드 당 포인터를 두어서, 현재 goal에 맞는 포인터가 있다면 하나씩 넘긴다..
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int 카드1_포인터 = 0;
        int 카드2_포인터 = 0;
        
        for(int i = 0; i <= goal.length - 1; i++) {
            
            if(카드1_포인터 <= cards1.length - 1) {
                if(cards1[카드1_포인터].equals(goal[i])) {
                    카드1_포인터 ++;
                    continue;
                }
            }
            
            if(카드2_포인터 <= cards2.length - 1) {
                if(cards2[카드2_포인터].equals(goal[i])) {
                    카드2_포인터 ++;
                    continue;
                }
            }
            
            return "No";
        }
        
        return "Yes";
    }
}