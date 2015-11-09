/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. */

public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int area = 0;
        while (left <= right) {
            int hLeft = height[left], hRight = height[right];
            if (hLeft <= hRight) {
                if (hLeft >= maxLeft) { maxLeft = hLeft; }
                else { area += maxLeft - hLeft; }
                left++;
            } else {
                if (hRight >= maxRight) { maxRight = hRight; }
                else { area += maxRight - hRight; }
                right--;
            }
        }
        return area;
    }
}
