/* The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
] */

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol = new ArrayList<>();
        if (n <= 0) { return sol; } // no solution
        
        int[] pos = new int[n];  // record which column to put for each row
        Arrays.fill(pos, -1);
        solve(n, 0, sol, pos);
        return sol;
    }
    
    private void solve(int n, int row, List<List<String>> sol, int[] pos) {
        if (row == n) {  // find a solution
            List<String> list = new ArrayList<>();
            for (int col : pos) {
                char[] chs = new char[n];
                Arrays.fill(chs, '.');
                chs[col] = 'Q';
                list.add(new String(chs));
            }
            sol.add(list);
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
            solve(n, row + 1, sol, pos);
            pos[row] = -1;
        }
    }
}
