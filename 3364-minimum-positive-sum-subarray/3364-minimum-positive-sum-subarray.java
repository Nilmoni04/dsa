class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int res = Integer.MAX_VALUE;

        for (int i = l; i <= r; i++) {
            int sum = 0;

            for (int j = 0; j < i; j++) 
                sum += nums.get(j);

            if ((sum > 0) && (sum < res)) 
                res = sum;

            for (int j = 1; j <= nums.size() - i; j++) {
                sum += nums.get(j + i - 1);
                sum -= nums.get(j - 1);

                if ((sum > 0) && (sum < res)) 
                    res = sum;
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}