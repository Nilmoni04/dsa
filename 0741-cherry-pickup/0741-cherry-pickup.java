class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == - 1 || grid[n - 1][n - 1] == -1) {
            return 0;
        }

        return memoization(grid);
    }

    private int rolling(int[][] grid) {
        int n = grid.length;

        int[][] prev = new int[n][n];
        for(int[] row: prev) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        prev[0][0] = grid[0][0];

        int[][] curr = new int[n][n];

        for(int step = 1; step < 2 * n - 1; step++) {
            for(int[] row: curr) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }

            for(int r1 = Math.max(0, step - (n - 1)); r1 <= Math.min(n - 1, step); r1++) {
                for(int c2 = Math.max(0, step - (n - 1)); c2 <= Math.min(n - 1, step); c2++) {
                    int c1 = step - r1;
                    int r2 = step - c2;

                    if(c2 > c1 || c1 >= n || r2 >= n) {
                        continue;
                    }

                    if(grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        continue;
                    }

                    int res = Integer.MIN_VALUE;

                    if(c1 > 0 && c2 > 0) {
                        res = Math.max(res, prev[r1][c2 - 1]);
                    }

                    if(c1 > 0 && r2 > 0) {
                        res = Math.max(res, prev[r1][c2]);
                    }

                    if(r1 > 0 && c2 > 0) {
                        res = Math.max(res, prev[r1 - 1][c2 - 1]);
                    }

                    if(r1 > 0 && r2 > 0) {
                        res = Math.max(res, prev[r1 - 1][c2]);
                    }

                    curr[r1][c2] = res + grid[r1][c1] + (c1 != c2 ? grid[r2][c2] : 0);
                }
            }

            int[][] tmp = curr;
            curr = prev;
            prev = tmp;
        }

        return Math.max(0, prev[n - 1][n - 1]);
    }

    private int tabulation(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];

        for(int[][] matrix: dp) {
            for(int[] row: matrix) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];

        for(int step = 1; step < 2 * n - 1; step++) {
            for(int r1 = Math.max(0, step - (n - 1)); r1 <= Math.min(n - 1, step); r1++) {
                for(int c2 = Math.max(0, step - (n - 1)); c2 <= Math.min(n - 1, step); c2++) {
                    int c1 = step - r1;
                    int r2 = step - c2;

                    if(c2 > c1 || c1 >= n || r2 >= n) {
                        continue;
                    }

                    if(grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        continue;
                    }

                    int res = Integer.MIN_VALUE;

                    if(c1 > 0 && c2 > 0) {
                        res = dp[r1][c1 - 1][c2 - 1]; //both left
                    }

                    if(c1 > 0 && r2 > 0) {
                        res = Math.max(res, dp[r1][c1 - 1][c2]); //left, up
                    }

                    if(r1 > 0 && c2 > 0) {
                        res = Math.max(res, dp[r1 - 1][c1][c2 - 1]); //up, left
                    }

                    if(r1 > 0 && r2 > 0) {
                        res = Math.max(res, dp[r1 - 1][c1][c2]); //up, up
                    }

                    if(res < 0) {
                        continue;
                    }

                    dp[r1][c1][c2] = res + grid[r1][c1] + (c1 != c2 ? grid[r2][c2] : 0);
                }
            }
        }

        return Math.max(0, dp[n - 1][n - 1][n - 1]);
    }

    private int memoization(int[][] grid) {
        int n = grid.length;
 
        Integer[][][] cache = new Integer[n][n][n]; //r1 + c1 = r2 + c2 => r2 = r1 + c1 - c2 => dp[r1][c1][c2] - max number of cherries picked by 
                                                        //arriving simultaneously at (r1,c1) and (r2,c2)

        return Math.max(0, memoization(grid, 0, 0, 0, cache));
    }

    private int memoization(int[][] grid, int r1, int c1, int c2, Integer[][][] cache) {
        int n = grid.length;

        int r2 = r1 + c1 - c2;

        if(r1 == n || c1 == n || r2 == n || c2 == n) { //out of bounds
            return -1;
        }

        if(c2 > c1) { //symmetry pruning - no need to explore equivalent pairs of paths, just gonna evaluate such pair once
                            //without it, assuming a path = branch1 + branch2, we'd explore:
                                //walker1 going branch1 + walker2 going branch2 AND
                                //walker2 going branch1 + walker1 going branch2
                            //which'd be redundant
                            //or in other words, no need to explore both memoization(r1,c1,c2) and memoization(r2,c2,c1) - both calls'd yield same result
                            
            return - 1; 
        }

        if(grid[r1][c1] == -1 || grid[r2][c2] == -1) { //obstacle
            return -1;
        }

        if(r1 == n - 1 && c1 == n - 1) { //finish
            return grid[r1][c1];
        }

        if(cache[r1][c1][c2] != null) {
            return cache[r1][c1][c2];
        }

        int res = memoization(grid, r1 + 1, c1, c2 + 1, cache); //down + right

        res = Math.max(res, memoization(grid, r1 + 1, c1, c2, cache)); //down + down

        res = Math.max(res, memoization(grid, r1, c1 + 1, c2, cache)); //right + down

        res = Math.max(res, memoization(grid, r1, c1 + 1, c2 + 1, cache)); //right + right

        if(res >= 0) { //only if valid path found
            res += grid[r1][c1];
            
            if(c1 != c2) { //if not on the same cell to avoid doubling - a single cherry can only be picked up once
                res += grid[r2][c2]; 
            }
        }

        return cache[r1][c1][c2] = res;
    }
}