class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;

        long ans = Long.MAX_VALUE;
        long[] min = new long[n];
        Arrays.fill(min, Long.MAX_VALUE);

        for(int k = 0; k < n; k++) {
            long sum = 0;
            for(int i = 0; i < n; i++) {
                min[i] = Math.min(min[i], nums[(i + k) % n]);
                sum += min[i];
            }

            ans = Math.min(ans, sum + (long) k * x);
        }

        return ans;
    }
}