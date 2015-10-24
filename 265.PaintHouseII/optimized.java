/*There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime? */
public int minCostII(int[][] costs) {
  if (costs == null || costs.length == 0) { return 0; }
  int n = costs.length;
  int k = costs[0].length;
  int prevMin = 0, prevSecondMin = 0;
  int prevMinIdx = 0, prevSecondMinIdx = 0;
  for (int i = 0; i < n; i++) {
    int curMin = Integer.MAX_VALUE, curSecondMin = Integer.MAX_VALUE;
    int curMinIdx = 0, curSecondMinIdx = 0;
    for (int j = 0; j < k; j++) {
      int cost = costs[i][j] + (j == prevMinIdx ? prevSecondMin : prevMin);
      if (cost < curMin) {
        curSecondMin = curMin;
        curMin = cost;
        curMinIdx = j;
      } else if (cost < curSecondMin) {
        curSecondMin = cost;
        curSecondMinIdx = j;
      }
    }
    prevMin = curMin;
    prevSecondMin = curSecondMin;
    prevMinIdx = curMinIdx;
    prevSecondMinIdx = curSecondMinIdx;
  }
  return prevMin;
}
