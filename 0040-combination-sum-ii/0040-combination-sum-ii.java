class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int st, int[] arr, int tar, List<Integer> curr, List<List<Integer>> res) {
        if(tar == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(tar < 0) return;
        for(int i=st; i<arr.length; i++) {
            curr.add(arr[i]);
            backtrack(i+1, arr, tar-arr[i], curr, res);
            curr.remove(curr.size()-1);

            while(i+1 < arr.length && arr[i] == arr[i+1]) {
                i++;
            }
        }
    }
}