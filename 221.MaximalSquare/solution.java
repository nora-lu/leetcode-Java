public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) { return 0; }
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i] - '0';
      if (dp[0][i] == 1) { max = 1; }
    }
    for (int i = 0; i < m; i++) {
      dp[i][0] = matrix[i][0] - '0';
      if (dp[i][0] == 1) { max = 1; }
    }
    
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '0') { dp[i][j] = 0; }
        else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          if (dp[i][j] > max) { max = dp[i][j]; }
        }
      }
    }
    return max * max;
  }
}
