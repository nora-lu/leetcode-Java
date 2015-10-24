public int minCostII(int[][] costs) {
  if (costs == null || costs.length == 0) { return 0; }
  int n = costs.length;  // n houses
  int k = costs[0].length;  // k colors
  int[][] dp = new int[n][k];
  
  for (int i = 0; i < k; i++) { dp[0][i] = costs[0][i]; }
  for (int i = 1; i < n; i++) {
    for (int j = 0; j < k; j++) {
      int min = Integer.MAX_VALUE;
      for (int m = 0; m < k; m++) {
        if (m == j) { continue; }
        min = Math.min(min, dp[i - 1][m]);
      }
      dp[i][j] = costs[i][j] + min;
    }
  }
  int minCost = dp[n - 1][0];
  for (int i = 1; i < k; i++) { minCost = Math.min(minCost, dp[n - 1][i]); }
  return minCost;
}
