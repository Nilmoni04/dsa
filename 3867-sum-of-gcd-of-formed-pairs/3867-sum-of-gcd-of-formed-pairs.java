import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;

        for (int i = 0; i < n / 2; i++) {
            ans += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}