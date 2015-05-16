public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) { return n; }
        int[] dp = new int[n];
        dp[0] = 1; // only 1 way to clime 1 step
        dp[1] = 2; // two ways to clime 2 steps
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
