class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int[] prev = pairs[0];
        int res=1;

        for(int i=1; i<pairs.length; i++) {
            int[] curr = pairs[i];
            if(curr[0] > prev[1]) {
                res++;
                prev = curr;
            }
        }
        return res;
    }
}