class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int[] counter = new int[n + 1];
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            ans[1] ^= (i + 1) ^ nums[i];

            if (++counter[nums[i]] == 2) {
                ans[0] = nums[i];
            }
        }
        ans[1] ^= ans[0];

        return ans;

    }
}