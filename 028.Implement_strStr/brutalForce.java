public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) { return -1; }
        // int n = haystack.length(), m = needle.length();
        // if (m == 0) { return 0; }
        
        // int i = 0, j = 0;
        // for (i = 0; i < n; i++) {
        //     for (j = 0; j < m && i + j < n; j++) {
        //         if (haystack.charAt(i + j) != needle.charAt(j)) { break; }
        //     }
        //     if (j == m) { return i; }
        // }
        // return -1;
        
        int len1 = haystack.length(), len2 = needle.length();
        
        int i = 0;
        while (i + len2 <= len1) {
            int j = i, k = 0;
            while (k < len2 && haystack.charAt(j) == needle.charAt(k)) { j++; k++; }
            if (k == len2) { return i; }
            i++;
        }
        return -1;
    }
}
