class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] nums, int st, List<Integer> path, List<List<Integer>> res) {
        if (st == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[st]);
        backtrack(nums, st+1, path, res);
        path.remove(path.size()-1);
        while (st + 1 < nums.length && nums[st] == nums[st + 1]) {
            st++;
        }
        backtrack(nums, st+1, path, res);
    }
}