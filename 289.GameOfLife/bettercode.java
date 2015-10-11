public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = m != 0 ? board[0].length : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;  // include cell itself
                for (int I = Math.max(i - 1, 0); I < Math.min(i + 2, m); I++) {
                    for (int J = Math.max(j - 1, 0); J < Math.min(j + 2, n); J++) {
                        count += board[I][J] & 1;  // right most bit is original state
                    }
                }
                if (count == 3 || count - board[i][j] == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // left most bit is new state
            }
        }
    }
}
