/* Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions. */

public class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) { return 0; } // no solution
        
        int[] pos = new int[n];  // record which column to put for each row
        Arrays.fill(pos, -1);
        solve(n, 0, pos);
        return count;
    }
    
    private void solve(int n, int row, int[] pos) {
        if (row == n) {  // find a solution
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            // check if in same column with Q above
            int i = 0;
            for ( ; i < row && pos[i] != col; i++) {}
            if (i < row) { continue; }
            // check if on same diagonal
            for (i = 0 ; i < row && Math.abs(row - i) != Math.abs(col - pos[i]); i++) {}
            if (i < row) { continue; }
            pos[row] = col;
            solve(n, row + 1, pos);
            pos[row] = -1;
        }
    }
}
