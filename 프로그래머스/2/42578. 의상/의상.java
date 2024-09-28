import java.util.*;

class Solution {
    
    // 하루에 최소 한 개의 의상
    // 다른 의상이 겹치지 않거나, 의상을 추가로 착용한 경우는 다른 방법으로 간주
    public int solution(String[][] clothes) {
        // TODO : 최소 1개 이상의, 서로 다른 조합의 수는?
        Map<String, List<String>> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            String product = cloth[0];
            String category = cloth[1];
                
            List<String> list = map.get(category);
            // 1) map에 존재하지 않다면 -> List 생성 후 넣기
            if(list == null) {
                List<String> productList = new ArrayList<>();
                productList.add(product);
                map.put(category, productList);   
            // 2) map에 존재한다면 -> List에 추가하기
            } else {
                list.add(product);
            }
        }
        
        int combinationCount = 1;
        for(String category : map.keySet()){
            combinationCount *= map.get(category).size() + 1;
        }
        
        return combinationCount - 1;
    }
}
