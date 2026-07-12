class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        int maxConsistent = 0;
        for(int i=0; i<n; i++) {
            dp[i]=1;
            for(int j=0; j<i; j++) {
                boolean isValid = true;
                for(int k=0; k<m; k++) {
                    if(Math.abs(grid[k][i] - grid[k][j]) > limit) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxConsistent = Math.max(maxConsistent, dp[i]);
        }
        return maxConsistent;
    }
}