public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) { return null; }
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int k = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = k++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = k++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = k++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = k++;
            }
            left++;
        }
        return res;
    }
}
