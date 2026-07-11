class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(k, 1, n, new ArrayList<>(), ans);
        return ans; 
    }

    public static void findCombination(int k, int num, int target, ArrayList<Integer> lst, List<List<Integer>> ans) {
        
        if (target == 0 && k == 0) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        for (int i = num; i < 10; i++) {
            if (i > target || k <= 0) break; 
            lst.add(i);
            findCombination(k - 1, i + 1, target - i, lst, ans);
            lst.remove(lst.size() - 1);
        }
    }
}