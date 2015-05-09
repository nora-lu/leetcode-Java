public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) { return -1; }
        int n = haystack.length(), m = needle.length();
        if (m == 0) { return 0; }
        
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m && i + j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) { break; }
            }
            if (j == m) { return i; }
        }
        return -1;
    }
}
