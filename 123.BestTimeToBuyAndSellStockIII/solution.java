/* Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) { return 0; }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        int minPrice = prices[0];
        left[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        int maxPrice = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        
        int maxPro = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxPro = Math.max(maxPro, left[i] + right[i]);
        }
        return maxPro;
    }
}
