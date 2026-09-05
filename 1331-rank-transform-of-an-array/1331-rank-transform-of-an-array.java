class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> rank = new HashMap<>();
        int currRank = 1;
        for(int nums : sorted) {
            if(!rank.containsKey(nums)) {
                rank.put(nums, currRank++);
            }
        }
        for(int i=0; i<arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
}