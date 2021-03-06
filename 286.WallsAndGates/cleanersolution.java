public class Solution {
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) { return; }
    int m = rooms.length, n = rooms[0].length;
    
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rooms[i][j] == 0) { q.offer(new int[]{i, j}); }
      }
    }
    while (!q.isEmpty()) {
      int[] top = q.poll();
      int i = top[0], j = top[1];
      if (i > 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
        rooms[i - 1][j] = rooms[i][j] + 1;
        q.offer(new int[]{i - 1, j});
      }
      if (j > 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
        rooms[i][j - 1] = rooms[i][j] + 1;
        q.offer(new int[]{i, j - 1});
      }
      if (i < m - 1 && rooms[i + 1][j] == Integer.MAX_VALUE) {
        rooms[i + 1][j] = rooms[i][j] + 1;
        q.offer(new int[]{i + 1, j});
      }
      if (j < n - 1 && rooms[i][j + 1] == Integer.MAX_VALUE) {
        rooms[i][j + 1] = rooms[i][j] + 1;
        q.offer(new int[]{i, j + 1});
      }
    }
  }
}
