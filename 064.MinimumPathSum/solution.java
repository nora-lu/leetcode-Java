public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }
        
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];
        minSum[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) { // update first column except first cell
            minSum[i][0] = minSum[i - 1][0] + grid[i][0];
        }
        
        for (int j = 1; j < n; j++) { // update first row except first cell
            minSum[0][j] = minSum[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i - 1][j]) + grid[i][j];
            }
        }
        return minSum[m - 1][n - 1];
    }
}
