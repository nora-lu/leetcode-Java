public class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        if (m > n) { return 0; }
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            int pre = 1;
            for (int i = 1; i <= m; i++) {
                int tmp = dp[i];
                dp[i] = dp[i] + (s.charAt(j - 1) == t.charAt(i - 1) ? pre : 0);
                pre = tmp;
            }
        }
        return dp[m];
    }
}
