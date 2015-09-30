public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) { return 0; }
        int m = grid.length, n = grid[0].length;
        boolean[][] isIsland = new boolean[m][n];
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
              if (!isIsland[i][j] && grid[i][j] == '1') {
                  dfs(grid, isIsland, i, j);
                  res++;
              }        
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, boolean[][] flag, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || flag[i][j]) { return; }
        flag[i][j] = true;
        dfs(grid, flag, i, j + 1);
        dfs(grid, flag, i, j - 1);
        dfs(grid, flag, i + 1, j);
        dfs(grid, flag, i - 1, j);
    }
}
