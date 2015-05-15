public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) { return 0; }
        int[] num_paths = new int[n + 1];
        num_paths[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                num_paths[j + 1] += num_paths[j];
            }
        }
        return num_paths[n];
    }
}
