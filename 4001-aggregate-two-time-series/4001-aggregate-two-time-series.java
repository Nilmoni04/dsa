class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> res = new ArrayList<>();
        int i=series1.length-1;
        int j=series2.length-1;
        long nextVal1=0, nextVal2=0;
        while(i>=0 || j>=0) {
            int currTimestamp;
            if(i>=0 && j>=0) {
                currTimestamp=Math.max(series1[i][0], series2[j][0]);
            } else if(i>=0) {
                currTimestamp = series1[i][0];
            } else {
                currTimestamp = series2[j][0];
            }
            if(i>=0 && series1[i][0] == currTimestamp) {
                nextVal1=series1[i][1];
                i--;
            }
            if(j>=0 && series2[j][0] == currTimestamp) {
                nextVal2=series2[j][1];
                j--;
            }
            long sum = nextVal1+nextVal2;
            res.add(Arrays.asList(currTimestamp, (int) sum));
        }
        Collections.reverse(res);
        return res;
    }
}