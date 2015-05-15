public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // special case: start grid has obstacle
        if (obstacleGrid == null || obstacleGrid.length == 0
            || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) { return 0; }
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        
        // initialize first column except for start grid
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) { // no obstacle
                paths[i][0] = paths[i - 1][0];
            } 
        }
        // initialize first row except for start grid
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                paths[0][j] = paths[0][j - 1];
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}
