/* Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true */

public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
    
    private boolean isMatch(String s, String p, int i, int j) {
        int lenS = s.length(), lenP = p.length();
        if (j == lenP) { return i == lenS; }
        if (j == lenP - 1 || p.charAt(j + 1) != '*') {
            if (i == lenS || (p.charAt(j) != '.' && s.charAt(i) != p.charAt(j))) { return false; }
            return isMatch(s, p, i + 1, j + 1);
        } 
        // p.charAt(j + 1) == '*'
        while (i < lenS && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            if (isMatch(s, p, i, j + 2)) { return true; }
            i++;
        }
        return isMatch(s, p, i, j + 2);
    }
}
