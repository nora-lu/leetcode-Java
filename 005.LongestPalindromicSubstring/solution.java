public class Solution {
    private int max = 1;
    private int maxStart = 0, maxEnd = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) { return s; }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, true);
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                helper(s, i, false); 
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
    
    private void helper(String s, int i, boolean findOddLen) {
        int lt = i - 1;
        int rt = findOddLen ? i + 1 : i + 2;
        while (lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) { lt--; rt++; }
        if (rt - lt - 1 > max) {
            max = rt - lt - 1;
            maxStart = lt + 1;
            maxEnd = rt - 1;
        }
    }
}
