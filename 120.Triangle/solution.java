public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) { return 0; }
        
        int n = triangle.size();
        int[] min = new int[n];
        // Initialize min with bottom row elements
        for (int i = 0; i < n; i++) {
            min[i] = triangle.get(n - 1).get(i);
        }
        
        for (int j = n - 2; j >= 0; j--) { // for each level j from bottom to up
            for (int k = 0; k <= j; k++) {
            // Find the lesser of its two children, and sum the current value in the triangle with it.
                min[k] = Math.min(min[k], min[k + 1]) + triangle.get(j).get(k);
            }
        }
        return min[0];
    }
}
