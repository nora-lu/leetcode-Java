public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) { return 0; }
        if (n == 1) { return k; }
        int numDiffColor = k * (k - 1), numSameColor = k;
        for (int i = 2; i < n; i++) {
            int tmp = numDiffColor;
            numDiffColor = (numDiffColor + numSameColor) * (k - 1);
            numSameColor = tmp;
        }
        return numSameColor + numDiffColor;
    }
}
