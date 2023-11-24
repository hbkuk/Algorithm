class Solution {
    public String solution(int n) {
        String[] array = new String[]{"수", "박"};
        
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            if(isFirst) {
                sb.append(array[0]);
                isFirst = false;
                continue;
            }
            sb.append(array[1]);
            isFirst = true;
        }
        
        return sb.toString();
    }
}