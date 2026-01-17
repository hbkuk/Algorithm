import java.util.*;

class Solution {
    
    // 요구사항
    // 1. 칼로리가 낮은 순으로 배치해야한다.
    // 2. 1:1 대결이기 때문에 2개씩 재고가 소진된다.
    
    // 구현사항
    // 1. food[1] 부터.. food[food.length - 1] 까지 순회.
    //  - food[i] / 2 => 결과
    //   결과 값은 배치할 수 있는 숫자다..
    // Stack에 하나씩 쌓는다..
    // Stack에 쌓인 것들을 빼서.. 앞과 뒤에 추가한다. 
    public String solution(int[] food) {
        
        Stack<Food> stack = new Stack();
        
        for(int i = 1; i <= food.length - 1; i++) {
            
            int 몫 = food[i] / 2;
            
            if(몫 > 0) {
                stack.push(new Food(i, 몫));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            Food pop = stack.pop();
            
            for(int i = 1; i <= pop.stock; i++) {
                sb.append(String.valueOf(pop.calorie));
            }
            
            System.out.println(sb.toString());
        }
        
        String 뒷_문장 = sb.toString();
        String 앞_문장 = sb.reverse().toString();
        return 앞_문장 + "0" + 뒷_문장;
    }
}

class Food {
    int calorie;
    int stock;
    
    Food(int calorie, int stock) {
        this.calorie = calorie;
        this.stock = stock;
    }
    
    int getCalorie() {
        return this.calorie;
    }
    
    int getStock() {
        return this.stock;
    }
}