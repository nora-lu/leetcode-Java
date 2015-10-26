public class Solution {
  public int maximalSquare(char[][] matrix) {
    int nr = matrix.length; 
    if (nr == 0) { return 0; }
    int nc = matrix[0].length;
    if (nc == 0) { return 0; }
    
    int[] dp = new int[nc + 1];
    int max = 0, topLeft = 0;
    for (int i = 1; i <= nr; i++) {
      for (int j = 1; j <= nc; j++) {
        int tmp = dp[j];  // result of last row of j
        if (matrix[i - 1][j - 1] == '0') { dp[j] = 0; }
        else {
          dp[j] = Math.min(dp[j], Math.min(dp[j - 1], topLeft)) + 1;
          if (dp[j] > max) { max = dp[j]; }
        }
        topLeft = tmp;
      }
    }
    return max * max;
  }
}
