import java.util.ArrayList;
import java.util.List;

public class Solution {  // Renamed the class to Solution
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Call the backtracking function starting from row 0
        backtrack(0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), board, result, n);
        return result;
    }

    private void backtrack(int row, List<Integer> diagonals, List<Integer> antiDiagonals, 
                           List<Integer> cols, char[][] board, List<List<String>> result, int n) {
        // Base case: If all queens are placed, add the current board to the result
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            // Check if the queen can be placed at the current position
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }

            // Place the queen
            board[row][col] = 'Q';
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            // Move to the next row
            backtrack(row + 1, diagonals, antiDiagonals, cols, board, result, n);

            // Backtrack: Remove the queen and try another position
            board[row][col] = '.';
            cols.remove(Integer.valueOf(col));
            diagonals.remove(Integer.valueOf(currDiagonal));
            antiDiagonals.remove(Integer.valueOf(currAntiDiagonal));
        }
    }

    // Helper function to construct the board as a list of strings
    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution nq = new Solution();
        int n = 4;  // Example for a 4x4 board
        List<List<String>> solutions = nq.solveNQueens(n);
        
        // Print the solutions
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
