class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int left = 0;
        int max = 2;

        for (int right = 0; right < n; right++) {

            while (true) {
                boolean valid = true;

                for (int i = left; i < right; i++) {
                    if (gcd(nums[i], nums[right]) != 1) {
                        valid = false;
                        break;
                    }
                }

                if (valid) break;

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}