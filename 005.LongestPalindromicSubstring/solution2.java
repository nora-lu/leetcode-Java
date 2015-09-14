public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) { return s; }
        
        int len = s.length();
        int maxStart = 0, maxEnd = 0;
        boolean[][] dp = new boolean[1000][1000];
        // update palindrome of length 1
        for (int i = 0; i < len; i++) { dp[i][i] = true; }
        // update palindrome of length 2
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxStart = i; maxEnd = i + 1;
            }
        }
        // update palindrome of length from 3 to len.
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxStart = i; maxEnd = j;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
