public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) { return false; }
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (midValue == target) { return true; }
            else if (midValue < target) { lo = mid + 1; }
            else { hi = mid - 1; }
        }
        return false;
    }
}
