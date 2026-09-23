class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] st_times = new int[n];
        int[] end_times = new int[n];

        for(int i=0; i<n; i++) {
            st_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }
        Arrays.sort(st_times);
        Arrays.sort(end_times);
        int end=0, count=0;
        for(int st : st_times) {
            if(st > end_times[end]) {
                end++;
            } else {
                count++;
            }
        }
        return count;
    }
}