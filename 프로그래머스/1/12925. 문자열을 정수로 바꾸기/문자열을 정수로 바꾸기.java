class Solution {
    public static int solution(String s) {
        char[] chars = s.toCharArray();

        if (!isNegative(chars[0])) {
            if(!hasSign(chars[0])) {
                return getResult(chars, 1, 1);
            }
            return getResult(chars, 0, 1);
        }
        return getResult(chars, 1, -1);
    }
    
   private static boolean hasSign(char c) {
        return (48 <= c && 57 >= c);
    }

    private static int getResult(char[] chars, int startIndex, int factor) {
        int sum = 0;

        for (int i = startIndex; i < chars.length; i++) {

            int num = 1;
            for (int j = chars.length - 1 - i; j > 0; j--) {
                num *= 10;
            }
            sum += ((chars[i] - 48) * num * factor);
        }
        return sum;
    }

    private static boolean isNegative(char c) {
        return c == '-';
    }
}