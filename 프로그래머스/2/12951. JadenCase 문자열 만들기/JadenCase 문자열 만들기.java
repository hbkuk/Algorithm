class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();

        String[] strings = s.toLowerCase().split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].isEmpty()) {
                result.append(" ");
                continue;
            }
            char firstChar = strings[i].charAt(0);
            if(firstChar >= 'a' && firstChar <= 'z') {
                result.append(strings[i].substring(0, 1).toUpperCase());
                result.append(strings[i].substring(1));
                result.append(" ");
                continue;
            }

            result.append(strings[i]);
            result.append(" ");
        }

        if(s.endsWith("  ")) {
            result.append("  ");
        }
        
        if(s.endsWith(" ")) {
            result.append(" ");
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }
}