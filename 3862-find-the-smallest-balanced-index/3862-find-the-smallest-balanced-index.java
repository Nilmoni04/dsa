class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long lsum = 0;
        for (int x : nums) lsum += x;

        long rprod = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            lsum -= nums[i];
            if (lsum == rprod)
                return i;
            if (rprod > lsum / nums[i])
                break;

            rprod *= nums[i];
        }

        return -1;
    }
}