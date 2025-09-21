class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        
        int 현재_초 = 0;
        int 현재_체력 = health;
        int 연속_성공_시간 = 0;
        
        int 시전_시간 = bandage[0];
        int 초당_회복량 = bandage[1];
        int 추가_회복량 = bandage[2];
        
        // 1. attacks 배열을 순회한다
        // - 공격 시간까지 ... 회복을 진행한다.
        for(int i = 0; i < attacks.length; i++) {
            if(현재_체력 <= 0) {
                return -1;
            }
            
            int[] 현재_공격_정보 = attacks[i];
            
            int 공격_초 = 현재_공격_정보[0];
            int 피해량 = 현재_공격_정보[1];
            
            // 현재 초에서 공격_초 전까지 붕대감기를 진행한다.
            int 회복_가능한_초 = 공격_초 - 현재_초;
            
            for(int j = 1; j < 회복_가능한_초; j++) {
                
                // 1. 초 늘리기
                현재_초 ++;
                
                // 2. 연속_성공_시간 늘리기
                연속_성공_시간 ++;
                
                // 3. 최대_체력이 현대 체력보다 클 경우 회복
                if(현재_체력 < health) {
                    현재_체력 += 초당_회복량;
                    
                    if(현재_체력 > health) {
                        현재_체력 = health;
                    }
                }

                // 4. 최대_체력이 현대 체력보다 크면서 연속_성공_시간에 충족하는 경우 회복
                if (연속_성공_시간 == 시전_시간) {
                    if (현재_체력 < health) {
                        현재_체력 += 추가_회복량;
                        if (현재_체력 > health) 현재_체력 = health;
                    }
                    연속_성공_시간 = 0; // 추가 회복 이후 초기화
                }
                
            }
            
            연속_성공_시간 = 0;
            현재_체력 -= 피해량;
            현재_초 ++;
            
            System.out.println(현재_초 + " 초에 \n 현재 체력은 ?" + 현재_체력);
        }
        
        
        if(현재_체력 <= 0) {
            return -1;
        }
        return 현재_체력;
    }
}