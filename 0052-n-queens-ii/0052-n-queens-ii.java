public class Solution { // Renamed the class to Solution
    static int count = 0; // To keep track of the number of solutions

    public int totalNQueens(int n) { // Added the totalNQueens method
        char[][] board = new char[n][n];
        
        // Initialize the board with 'x'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        count = 0; // Reset count before solving
        nQueens(board, 0); // Start solving from the 0th row
        return count; // Return the total number of solutions
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // Vertical up check
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Left upper diagonal check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Right upper diagonal check
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][], int row) {
        // Base case: if row == n, a solution has been found
        if (row == board.length) {
            count++; // Increment the solution count
            return;
        }

        // Try placing a queen in every column of the current row
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // Place the queen
                nQueens(board, row + 1); // Recursive call for next row
                board[row][j] = 'x'; // Backtracking step (remove queen)
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4; // Example for a 4x4 board
        int result = solution.totalNQueens(n);
        System.out.println("Total ways to solve " + n + "-Queens problem: " + result);
    }
}
