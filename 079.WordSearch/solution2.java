public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) { return true; }
        if (board == null || board.length == 0) { return false; }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, 0, i, j)) { return true; }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int idx, int i, int j) {
        int m = board.length, n = board[0].length;
        if (idx == word.length()) { return true; }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '*') { return false; }
        
        boolean ret = false;
        if (word.charAt(idx) == board[i][j]) {
            char tmp = board[i][j];
            board[i][j] = '*';
            if (search(board, word, idx + 1, i - 1, j) ||
                search(board, word, idx + 1, i + 1, j) ||
                search(board, word, idx + 1, i, j - 1) ||
                search(board, word, idx + 1, i, j + 1)) {
                ret = true;
            }
            board[i][j] = tmp;
        }
        return ret;
    }
}
