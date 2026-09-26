class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        for(int i=0; i<n; i++) {
            long currSum = 0;
            Set<Integer> remainders = new HashSet<>();

            for(int j=i; j<n; j++) {
                currSum += nums[j];
                int sumRemainder = (int) (currSum % k);
                if(sumRemainder < 0) {
                    sumRemainder += k;
                }
                int doubleRemainder = (2 * nums[j]) % k;
                if(doubleRemainder < 0) {
                    doubleRemainder += k;
                }
                remainders.add(doubleRemainder);

                if(sumRemainder == 0 || remainders.contains(sumRemainder)) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}