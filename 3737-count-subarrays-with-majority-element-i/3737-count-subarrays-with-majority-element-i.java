class Solution {
    class SegmentTree {
        int[] tree;
        int n;
        int count = 0;

        SegmentTree(int[] nums, int target) {
            n = nums.length;
            tree = new int[4 * n];
            build_tree(0, 0, n - 1, target, nums);
        }

        void build_tree(int node, int start, int end, int target, int[] nums) {
            if (start == end) {
                if (nums[start] == target) {
                    tree[node] = 1;
                    count++;
                }
                return;
            }

            int mid = (start + end) >> 1;
            build_tree(2 * node + 1, start, mid, target, nums);
            build_tree(2 * node + 2, mid + 1, end, target, nums);

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];

            return;

        }

        public int query(int node, int start, int end, int l, int r) {
            if (l > end || r < start) {
                return 0;
            }

            if (start >= l && end <= r) {
                return tree[node];
            }

            int mid = (start + end) >> 1;

            int leftSum = query(2 * node + 1, start, mid, l, r);
            int rightSum = query(2 * node + 2, mid + 1, end, l, r);

            return leftSum + rightSum;

        }

    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        SegmentTree st = new SegmentTree(nums, target);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int count = st.query(0, 0, n - 1, i, j);
                if (count > (j - i + 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}