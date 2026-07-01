class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, path, res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if( (i>0 && nums[i]==nums[i-1]) && !used[i-1] || (used[i]) ) continue;

            path.add(nums[i]);
            used[i]=true;
            backtrack(nums, used, path, res);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}