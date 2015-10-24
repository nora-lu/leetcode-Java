public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.startsWith("0")) { return 0; }
    int len = s.length();
    int[] dp = new int[len + 1];
    dp[0] = 1;
    dp[1] = 1;  // s cannot start with '0'
    for (int i = 2; i <= len; i++) {
      int n = Integer.parseInt(s.substring(i - 2, i));
      if (n >= 10 && n <= 26) {
        dp[i] += dp[i - 2]; 
      }
      if (s.charAt(i - 1) != '0') { dp[i] += dp[i - 1]; }
    }
    return dp[len];
  }
}
