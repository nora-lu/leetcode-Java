public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) { return false; }
        int ls = s.length(), lt = t.length();
        if (Math.abs(ls - lt) > 1) { return false; }
        
        int i = 0, j = 0;
        boolean edit = false;
        while (i < ls && j < lt) {
            if (s.charAt(i) != t.charAt(j)) {
                if (edit) { return false; }
                else {
                    edit = true;
                    if (ls == lt) { i++; j++; } 
                    else if (ls < lt) {  j++; } 
                    else { i++; }
                }
            } else { i++; j++; }
        }
        return ls == lt ? edit : true;
    }
}
