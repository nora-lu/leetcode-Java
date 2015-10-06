public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null) { return 0; }
        
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        
        // scan from left, compare with left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) { candy[i] = candy[i - 1] + 1; }
        }
        
        // scan from right, compare with right neighbor
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        
        int min = 0;
        for (int x : candy) { min += x; }
        return min;
    }
}
