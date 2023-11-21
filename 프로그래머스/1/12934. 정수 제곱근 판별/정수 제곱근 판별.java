class Solution {
    public long solution(long n) {
        if (n == 1) {
            return 4;
        }

        long left = 1;
        long right = n / 2;

        while (left <= right) {
            long mid = (right + left) / 2;

            if (n / mid == mid && n % mid == 0) {
                return (mid + 1) * (mid + 1);
            } else if (n / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
