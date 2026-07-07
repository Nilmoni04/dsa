class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return solve(grid, 0,0,0);
    }
    private boolean solve(int[][] grid, int r, int c, int expected) {
        int n = grid.length;
        if(r<0 || r>=n || c<0 || c>=n || grid[r][c] != expected) {
            return false;
        }
        if(expected == (n*n)-1) return true;
        boolean ans1 = solve(grid, r-2, c+1, expected+1);
        boolean ans2 = solve(grid, r-1, c+2, expected+1);
        boolean ans3 = solve(grid, r-2, c-1, expected+1);
        boolean ans4 = solve(grid, r-1, c-2, expected+1);
        boolean ans5 = solve(grid, r+2, c+1, expected+1);
        boolean ans6 = solve(grid, r+1, c+2, expected+1);
        boolean ans7 = solve(grid, r+2, c-1, expected+1);
        boolean ans8 = solve(grid, r+1, c-2, expected+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}