public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null) { return; }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = countLives(board, i, j);
                if (board[i][j] == 1) {  // live cell
                    board[i][j] = (lives == 2 || lives == 3) ? 1 : -1;  // live->die: -1
                } else {
                    board[i][j] = lives == 3 ? 2 : 0;  // die->live: 2
                }
            }
        }
        // restore -1 and 2 cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) { board[i][j] = 0; }
                else if (board[i][j] == 2) { board[i][j] = 1; }
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j) {
        int ctr = 0;
        if (isLive(board, i - 1, j - 1)) { ctr++; }
        if (isLive(board, i - 1, j)) { ctr++; }
        if (isLive(board, i - 1, j + 1)) { ctr++; }
        if (isLive(board, i, j - 1)) { ctr++; }
        if (isLive(board, i, j + 1)) { ctr++; }
        if (isLive(board, i + 1, j - 1)) { ctr++; }
        if (isLive(board, i + 1, j)) { ctr++; }
        if (isLive(board, i + 1, j + 1)) { ctr++; }
        return ctr;
    }
    
    private boolean isLive(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j <0 || j >= n) { return false; }
        if (board[i][j] == 1 || board[i][j] == -1) { return true; }
        else { return false; }
    }
}
