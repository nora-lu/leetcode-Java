public class Solution {
    private Set<Integer> occupiedCols = new HashSet<>();
    private Set<Integer> occupiedDiag1 = new HashSet<>();
    private Set<Integer> occupiedDiag2 = new HashSet<>();
    
    public int totalNQueens(int n) {
        return total(n, 0, 0);
    }
    
    private int total(int n, int row, int count) {
        for (int col = 0; col < n; col++) {
            if (occupiedCols.contains(col)) { continue; }
            int diag1 = row - col;
            if (occupiedDiag1.contains(diag1)) { continue; }
            int diag2 = row + col;
            if (occupiedDiag2.contains(diag2)) { continue; }
            if (row == n - 1) {
                count++;
                return count;
            }
            occupiedCols.add(col);
            occupiedDiag1.add(diag1);
            occupiedDiag2.add(diag2);
            count = total(n, row + 1, count);
            occupiedCols.remove(col);
            occupiedDiag1.remove(diag1);
            occupiedDiag2.remove(diag2);
        }
        return count;
    }
}
