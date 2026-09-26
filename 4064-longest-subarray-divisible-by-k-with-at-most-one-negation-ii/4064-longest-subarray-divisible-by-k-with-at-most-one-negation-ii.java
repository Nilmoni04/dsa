class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int[] firstPrefix = new int[k];
        int[] lastPrefix = new int[k];
        int[] firstValue = new int[k];
        int[] lastValue = new int[k];

        Arrays.fill(firstPrefix, -1);
        Arrays.fill(firstValue, -1);

        firstPrefix[0] = 0;
        int prefix = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i] % k;
            if (x < 0) {
                x += k;
            }

            if (firstValue[x] == -1) {
                firstValue[x] = i;
            }

            lastValue[x] = i;

            prefix = (prefix + x) % k;

            if (firstPrefix[prefix] == -1) {
                firstPrefix[prefix] = i + 1;
            }

            lastPrefix[prefix] = i + 1;
        }

        int res = 0;

        for (int right = 0; right < k; right++) {
            if (firstPrefix[right] != -1) {
                res = Math.max(res, lastPrefix[right] - firstPrefix[right]);
            }
        }

            for (int x = 0; x < k; x++) {
                if (firstValue[x] == -1) {
                    continue;
                }

                int need = (2 * x) % k;

                for (int startRem = 0; startRem < k; startRem++) {
                    if (firstPrefix[startRem] == -1) {
                        continue;
                    }

                    int endRem = (startRem + need) % k;

                    if (lastPrefix[endRem] <= firstPrefix[startRem]) {
                        continue;
                    }

                    if (firstValue[x] < lastPrefix[endRem] && lastValue[x] >= firstPrefix[startRem]) {
                        res = Math.max(res, lastPrefix[endRem] - firstPrefix[startRem]);
                    }
                }
            }

        return res;
    }
}