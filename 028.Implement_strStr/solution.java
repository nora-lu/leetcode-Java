public class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        if (nLen > hLen) return -1;
        if (nLen == 0) return 0;
        
        int i = 0, j = 0, k = 0;
        while (i < hLen && i + nLen <= hLen) {
            k = i;
            while (j < nLen) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    j = 0;
                    break;
                }
                j++;
                k++;
            }
            if (j == nLen) return i;
            i++;
        }
        return -1;
    }
}
