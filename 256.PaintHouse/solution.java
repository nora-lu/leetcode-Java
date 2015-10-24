/* There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers. */

public class Solution {
  public int minCost(int[][] costs) {
    if (costs == null) { return 0; }
    int r = 0, b = 0, g = 0;
    for (int i = 0; i < costs.length; i++) {
      int rr = r, bb = b, gg = g;
      r = costs[i][0] + Math.min(bb, gg);
      b = costs[i][1] + Math.min(rr, gg);
      g = costs[i][2] + Math.min(rr, bb);
    }
    return Math.min(r, Math.min(b, g));
  }
}
