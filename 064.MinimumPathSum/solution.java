public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) { return 0; }
        
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];
        minSum[0][0] = grid[0][0];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) { // first row, only has path from its left cell
                    minSum[i][j] = minSum[i][j - 1] + grid[i][j];
                }
                if (j == 0 && i > 0) { // first column, only has path from its upper cell
                    minSum[i][j] = minSum[i - 1][j] + grid[i][j];
                }
                if (i > 0 && j > 0) {
                    minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i - 1][j]) + grid[i][j];
                }
            }
        }
        return minSum[m - 1][n - 1];
    }
}
