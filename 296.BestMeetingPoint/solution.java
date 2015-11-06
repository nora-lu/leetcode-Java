/* A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

Hint:

Try to solve it in one dimension first. How can this solution apply to the two dimension case?  */

public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) { return 0; }
        return helper(grid, 0) + helper(grid, 1);
    }
    
    private int helper(int[][] grid, int dim) {
        int m = grid.length, n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        if (dim == 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) { list.add(i); }
                }
            }
        } else if (dim == 1) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == 1) { list.add(j); }
                }
            }
        }
        int lo = 0, hi = list.size() - 1;
        int total = 0;
        while (lo < hi) { total += list.get(hi--) - list.get(lo++); }
        return total;
    }
}
