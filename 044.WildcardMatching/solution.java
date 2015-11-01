/* Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false */

public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, startIdx = -1, match = 0;
        int lenS = s.length(), lenP = p.length();
        while (i < lenS) {
            //advancing both pointers when (both characters match) or ('?' found in pattern)
            if (j < lenP && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < lenP && p.charAt(j) == '*') {  // * found, only advancing pattern pointer
                startIdx = j;
                match = i;
                j++;
            } else if (startIdx != -1) {  // last pattern pointer was *, advancing string pointer
                j = startIdx;
                match++;
                i = match;
            } else { return false; }  //current pattern pointer is not star, last patter pointer was not *
                                      //characters do not match
        }
        while (j < lenP && p.charAt(j) == '*') { j++; }
        return j == lenP;
    }
}
