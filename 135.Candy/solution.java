public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) { return 0; }
        
        int len = ratings.length;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        
        // scan from left, compare with left neighbor
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) { candy[i] = candy[i - 1] + 1; }
        }
        
        int min = candy[len - 1];
        // scan from right, compare with right neighbor and compute the total
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            min += candy[i];
        }
        return min;
    }
}
