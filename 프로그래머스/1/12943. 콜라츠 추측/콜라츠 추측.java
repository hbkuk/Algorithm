class Solution {

    public int solution(long num) {
        int count = 0;

        while (num != 1) {
            if (isExceedLimit(count)) {
                return -1;
            }
            num = applyCollatzRule(num);
            count++;
        }
        return count;
    }

    private static long applyCollatzRule(long target) {
        if (target % 2 == 0) {
            return target / 2;
        }
        return target * 3 + 1;
    }

    private static boolean isExceedLimit(int count) {
        return count > 500;
    }
}