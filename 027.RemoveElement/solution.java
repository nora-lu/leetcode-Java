public class Solution {
    public int removeElement(int[] A, int elem) {
        int newLen = -1, i = 0;
        while (i < A.length) {
            if (A[i] != elem) A[++newLen] = A[i];
            i++;
        }
        return newLen + 1;
    }
}
