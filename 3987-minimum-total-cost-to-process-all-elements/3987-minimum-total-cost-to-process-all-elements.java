class Solution {
    public int minimumCost(int[] nums, int k) {
        long curr = k;
        long totalCost = 0;
        long opCount = 0;
        long MOD = 1000000007;

        for(int num : nums) {
            
            if(curr < num) {
                long opsNeed = (num - curr +k-1)/k;
                long nextOpCount = opCount + opsNeed;

                long sumNext = (nextOpCount % MOD) * ((nextOpCount+1)%MOD)/2;
                long sumCurr = (opCount % MOD) * ((opCount+1)%MOD)/2;

                totalCost = (totalCost+(sumNext-sumCurr)%MOD + MOD)%MOD;
                opCount = nextOpCount;
                curr += opsNeed*k;
            }
            curr -= num;
        }
        return (int) totalCost;
    }
}