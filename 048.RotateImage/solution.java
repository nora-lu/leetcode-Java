public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // swap symmetry 
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        
        // reverse every row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }
    
    private void swap(int[][] a, int i, int j, int m, int n) {
        int tmp = a[i][j];
        a[i][j] = a[m][n];
        a[m][n] = tmp;
    }
}
