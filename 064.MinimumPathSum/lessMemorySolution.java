public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }
        
        int m = grid.length, n = grid[0].length;
        int[] minSum = new int[n + 1];
        Arrays.fill(minSum, Integer.MAX_VALUE);
        // pay attention: minSum[0] = Integer.MAX_VALUE
        minSum[1] = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minSum[j + 1] = Math.min(minSum[j], minSum[j + 1]) + grid[i][j];
            }
        }
        return minSum[n];
    }
}
