public class Solution {
  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          bfs(grid, i, j);
        }
      }
    }
    return count;
  }

  private void bfs(char[][] grid, int x, int y) {
    grid[x][y] = '0';
    int m = grid.length, n = grid[0].length;
    Queue<Integer> q = new LinkedList<>();
    q.offer(x * n + y);
    
    while (!q.isEmpty()) {
      int idx = q.poll();
      int i = idx / n, j = idx % n;
      if (i > 0 && grid[i - 1][j] == '1') {
        q.offer((i - 1) * n + j);
        grid[i - 1][j] = '0';      
      } 
      if (i < m - 1 && grid[i + 1][j] == '1') {
        q.offer((i + 1) * n + j);
        grid[i + 1][j] = '0';
      }
      if (j > 0 && grid[i][j - 1] == '1') {
        q.offer(i * n + (j - 1));
        grid[i][j - 1] = '0';
      }
      if (j < n - 1 && grid[i][j + 1] == '1') {
        q.offer(i * n + (j + 1));
        grid[i][j + 1] = '0';
      }
    }
  }
}
