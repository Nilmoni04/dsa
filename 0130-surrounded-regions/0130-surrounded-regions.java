class Solution {
    private void dfs(char[][] board, int x, int y, char prevChar, char newChar) {
        int m=board.length, n=board[0].length;
        if(x<0 || y <0 || x>=m || y>=n) return;
        if(board[x][y] != prevChar) return;
        board[x][y] = newChar;
        dfs(board, x+1, y, prevChar, newChar);
        dfs(board, x-1, y, prevChar, newChar);
        dfs(board, x, y+1, prevChar, newChar);
        dfs(board, x, y-1, prevChar, newChar);
    }
    public void solve(char[][] board) {
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = '-';
                }
            }
        }
        for(int i=0; i<m; i++) {
            if(board[i][0] == '-') dfs(board, i, 0, '-', 'O');
            if(board[i][n-1] == '-') dfs(board, i, n-1, '-', 'O');
        }
        for(int j=0; j<n; j++) {
            if(board[0][j] == '-') dfs(board, 0, j, '-', 'O');
            if(board[m-1][j] == '-') dfs(board, m-1, j, '-', 'O');
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == '-') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}