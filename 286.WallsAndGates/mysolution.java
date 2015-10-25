/*  You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4   */

class Position {
  public int i;
  public int j;
  public Position(int x, int y) { i = x; j = y; }
}
public class Solution {
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) { return; }
    int m = rooms.length, n = rooms[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rooms[i][j] == 0) {  // is a gate
          bfs(rooms, i, j);
        }
      }
    }
  }

  private void bfs(int[][] rooms, int i, int j) {
    Queue<Position> q = new LinkedList<Position>();
    q.offer(new Position(i, j));
    int dist = -1;
    boolean[][] visited = new boolean[rooms.length][rooms[0].length];
    while (!q.isEmpty()) {
      int size = q.size();
      dist++;
      for (int k = 0; k < size; k++) {
        Position p = q.poll();
        int ii = p.i, jj = p.j;
        if (rooms[ii][jj] > dist) { rooms[ii][jj] = dist; }
        visited[ii][jj] = true;
        addCell(q, ii - 1, jj, visited, rooms);
        addCell(q, ii + 1, jj, visited, rooms);
        addCell(q, ii, jj - 1, visited, rooms);
        addCell(q, ii, jj + 1, visited, rooms);
      }
    }
  }

  private void addCell(Queue<Position> q, int i, int j, boolean[][] visited, int[][] rooms) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || visited[i][j]) {
      return;
    }
    if (rooms[i][j] != 0 && rooms[i][j] != -1) {
      q.offer(new Position(i, j));
    }
  }
}
