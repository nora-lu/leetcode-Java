public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) { return 0; }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j + 1] += dp[j];
            }
        }
        return dp[n];
    }
}
