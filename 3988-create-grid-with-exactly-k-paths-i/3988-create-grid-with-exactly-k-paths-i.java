class Solution {
    public String[] createGrid(int m, int n, int k) {
        char[][] grid = new char[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(grid[i], '.');
        }

        long total = countPaths(grid, m, n);
        if(k > total) {
            return new String[0];
        }
        if(k == total) {
            return convert(grid);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if((i == 0 && j==0) || (i == m-1 && j == n-1)) {
                    continue;
                }
                grid[i][j] = '#';
                long currPaths = countPaths(grid, m, n);

                if(currPaths == k) {
                    return convert(grid);
                } else if(currPaths < k) {
                    grid[i][j] = '.';
                }
            }
        }
        if(countPaths(grid, m, n) == k) {
            return convert(grid);
        }
        return new String[0];
    }
    private long countPaths(char[][] grid, int m, int n) {
        if(grid[0][0] == '#' || grid[m-1][n-1] == '#') return 0;
        long[][] dp = new long[m][n];
        dp[m-1][n-1]=1;

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(grid[i][j] == '#') {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == m-1 && j==n-1) continue;

                long down = (i+1 < m) ? dp[i+1][j] : 0;
                long right = (j+1 < n) ? dp[i][j+1] : 0;
                dp[i][j] = down+right;
            }
        }
        return dp[0][0];
    }
    private String[] convert(char[][] grid) {
        String[] res = new String[grid.length];
        for(int i=0; i<grid.length; i++) {
            res[i] = new String(grid[i]);
        }
        return res;
    }
}