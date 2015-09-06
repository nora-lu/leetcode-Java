public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         *  O(m + n) time solution. Rule out one column or row each time. 
         */
        if (matrix == null) { return false; }
        // start searching from the top right element
        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) { return true; }
            else if (target < matrix[row][col]) { col--; }
            else { row++; }
        }
        return false;
    }
}
