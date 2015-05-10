public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) { return false; }
        if (matrix[0] == null || matrix[0].length == 0) { return false; }
        
        int m = matrix.length, n = matrix[0].length;
        
        // find the row index, the last number <= target 
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            int mid_value = matrix[mid][0];
            if (mid_value == target) { return true; }
            else if (mid_value > target) { hi = mid - 1; }
            else { lo = mid; }
        }
        if (matrix[lo][0] > target) { return false; }
        
        // find the column index, the number equal to target
        int row = lo;
        lo = 0; 
        hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int mid_value = matrix[row][mid];
            if (mid_value == target) { return true; }
            else if (mid_value > target) { hi = mid - 1;}
            else { lo = mid + 1; }
        }
        return false;
    }
}
