class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(res, board, n, 0);
        return res;
    }
    private void backtracking(List<List<String>> res, char[][] board, int n, int row) {
        List<String> sol = new ArrayList<>();
        if(row == n) {
            for(char[] charArr : board) {
                sol.add(new String(charArr));
            }
            res.add(sol);
            return;
        }
        for(int i=0; i<n; i++) {
            if(isSafe(row, i, board, n)) {
                board[row][i] = 'Q';
                backtracking(res, board, n, row+1);
                board[row][i] = '.';
            }
        }
    }
    private boolean isSafe(int row, int col, char[][] board, int n) {
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') return false;
        }
        int i=row, j=col;
        while(i>=0 && j>=0) {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i=row; j=col;
        while(i >= 0 && j<n) {
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}