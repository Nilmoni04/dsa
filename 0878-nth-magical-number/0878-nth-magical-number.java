class Solution {
    public int nthMagicalNumber(int n, int a, int b) {   
        long MOD = 1_000_000_007;

        long left = 1;
        long right = (long) n * Math.min(a, b);

        long lcm = (long) a * b / gcd(a, b);

        while (left < right) {
            long mid = left + (right - left) / 2;

            long count = mid / a + mid / b - mid / lcm;

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left % MOD);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}