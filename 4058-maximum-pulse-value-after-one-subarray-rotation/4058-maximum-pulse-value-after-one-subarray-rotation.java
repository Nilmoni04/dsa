class Solution {
    public long maxValue(int[] nums) {
        int n = nums.length;
        long orgPulse = 0;
        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                orgPulse += nums[i];
            } else {
                orgPulse -= nums[i];
            }
        }
        if(n < 2) {
            return orgPulse;
        }

        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++) {
            if(i % 2 == 0) {
                prefix[i] = prefix[i-1]+nums[i];
            } else {
                prefix[i] = prefix[i-1]-nums[i];
            }
        }
        long maxPulse = orgPulse;
        long F1 = 2*prefix[0]-nums[0];
        long maxForEven = F1+nums[0];
        long maxForOdd = F1-nums[0];

        for(int r=1; r<n; r++) {
            long d;
            if(r%2 == 0) {
                d = maxForEven - 2*prefix[r];
            } else {
                d = maxForOdd - 2*prefix[r];
            }
            maxPulse = Math.max(maxPulse, orgPulse+d);

            long Fr = 2*prefix[r]-(r%2 == 0 ? nums[r] : -nums[r]);
            maxForEven = Math.max(maxForEven, Fr+nums[r]);
            maxForOdd = Math.max(maxForOdd, Fr-nums[r]);
        }
        return maxPulse;
    }
}