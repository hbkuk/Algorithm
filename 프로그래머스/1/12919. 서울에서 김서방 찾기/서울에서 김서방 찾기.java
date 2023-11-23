class Solution {
    public String solution(String[] seoul) {
        String targetString = "Kim";
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은").append(" ");
            
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals(targetString)) {
                sb.append(i);
                break;
            }
        }
        
        sb.append("에 있다");
        return sb.toString();
    }
}