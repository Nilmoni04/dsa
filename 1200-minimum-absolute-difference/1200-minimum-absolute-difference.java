class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<arr.length-1; i++) {
            int currDiff = Math.abs(arr[i+1]-arr[i]);
            if(currDiff < minDiff) {
                minDiff = currDiff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i+1]));
            } else if(currDiff == minDiff) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return res;
    }
}