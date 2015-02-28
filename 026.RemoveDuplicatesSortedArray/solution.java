public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len < 2) return len;
        
        int newLen = 0, i = 0;
        while (i < A.length) {
            if (A[i] != A[newLen]) {
                A[++newLen] = A[i];
            }
            i++;
        }
        return newLen + 1;
    }
}
