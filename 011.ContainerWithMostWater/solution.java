public class Solution {
    public int maxArea(int[] height) {
        int len = height.length, lo = 0, hi = len - 1;
        int maxArea = 0;
        while (lo < hi) {
            maxArea = Math.max(maxArea, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] < height[hi]) { lo++; }
            else { hi--; }
        }
        return maxArea;
    }
}
