/* Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range. */

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) { return 0; }
        int min = nums[0], max = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        int len = nums.length;
        int minGap = (int)Math.ceil((double)(max - min)/(len - 1));
        int[] bucketMin = new int[len - 1];
        int[] bucketMax = new int[len - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        // put numbers in buckets
        for (int n : nums) {
            if (n == min || n == max) { continue; }  // exclude min and max
            int idx = (n - min) / minGap;
            bucketMin[idx] = Math.min(bucketMin[idx], n);
            bucketMax[idx] = Math.max(bucketMax[idx], n);
        }
        int prev = min, maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) { continue; }
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - prev);
        return maxGap;
    } 
}
