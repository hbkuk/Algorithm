import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int 터트린_횟수 = 0;
        
        Stack<Integer> 스택 = new Stack();
        
        for(int i = 0; i < moves.length; i++) {
            int 집는_영역_인덱스 = moves[i] - 1;
            
            for(int j = 0; j < board.length; j++) {
                
                int 집을_인형_모양 = board[j][집는_영역_인덱스];
                if(집을_인형_모양 != 0) {
                    if(!스택.empty() && 스택.peek() == 집을_인형_모양 ) {
                        System.out.println("집을_인형_모양: " + 집을_인형_모양);
                        System.out.println("스택.peek(): " + 스택.peek());
                        스택.pop(); 
                        터트린_횟수 += 2;
                    } else {
                        System.out.println("넣습니다.: " + 집을_인형_모양);
                        스택.push(집을_인형_모양);
                    }
                    board[j][집는_영역_인덱스] = 0;
                    break;
                }
            }
        }
        
        
        return 터트린_횟수;
    }
}