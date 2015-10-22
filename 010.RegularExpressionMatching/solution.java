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
