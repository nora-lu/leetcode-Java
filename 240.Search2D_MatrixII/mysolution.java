public class Solution {
    /**
     *  O(MlogN) solution.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) { return false; }
        int m = matrix.length, n = matrix[0].length;
        // find index of last row with first number <= target
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            int midVal = matrix[mid][0];
            if (midVal == target) { return true; }
            else if (midVal > target) { hi = mid - 1; }
            else { lo = mid; }
        }
        
        int rowMax = lo;
        for (int i = 0; i <= rowMax; i++) {
            lo = 0; hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int midVal = matrix[i][mid];
                if (midVal == target) { return true; }
                else if (midVal > target) { hi = mid - 1; }
                else { lo = mid + 1; }
            }
        }
        return false;
    }
}
