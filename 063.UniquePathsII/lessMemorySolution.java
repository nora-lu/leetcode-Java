public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 
            || obstacleGrid[0].length == 0) { return 0; }
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] paths = new int[n];
        paths[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) { paths[j] = 0; }
                else if (j > 0) { paths[j] += paths[j - 1]; }
            }
        }
        return paths[n - 1];
    }
}
