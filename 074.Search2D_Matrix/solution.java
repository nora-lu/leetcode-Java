public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return false; }
        
        int lo = 0, hi = matrix.length * matrix[0].length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int midValue = convert(matrix, mid);
            if (midValue == target) { return true; }
            else if (midValue < target) { lo = mid + 1; }
            else { hi = mid - 1; }
        }
        return false;
    }
    
    // convert 1D position to 2D position, return the element at that position
    private static int convert(int[][] matrix, int pos) {
        int m = matrix.length, n = matrix[0].length;
        int row = pos / n;
        int col = pos - row * n;
        return matrix[row][col];
    }
}
