/* Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X   */

public class Solution {
    public void solve(char[][] board) {
        if (board == null) { return; }
        int m = board.length; 
        if (m == 0) { return; }
        int n = board[0].length;
        if (n == 0) { return; }
        
        // start from O on four edges, flood fill all connected O with #
        for (int i = 0; i < m; i++) {
            fill(board, i, 0);
            fill(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            fill(board, 0, j);
            fill(board, m - 1, j);
        }
        
        // recover # back to O, fill O with X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') { board[i][j] = 'O'; }
                else if (board[i][j] == 'O') { board[i][j] = 'X'; }
            }
        }
    }
    
    private void fill(char[][] board, int i, int j) {
        if (board[i][j] != 'O') { return; }
        board[i][j] = '#';
        
        int m = board.length, n = board[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i * n + j);
        while (!q.isEmpty()) {
            int pos = q.poll();
            int row = pos / n, col = pos % n;
            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '#';
                q.offer((row - 1) * n + col);
            }
            if (row + 1 < m && board[row + 1][col] == 'O') {
                board[row + 1][col] = '#';
                q.offer((row + 1) * n + col);
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '#';
                q.offer(row * n + col - 1);
            }
            if (col + 1 < n && board[row][col + 1] == 'O') {
                board[row][col + 1] = '#';
                q.offer(row * n + col + 1);
            }
        }
    }
}
