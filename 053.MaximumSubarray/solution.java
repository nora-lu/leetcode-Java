public class Solution {
    // DP solution
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }

        int max = nums[0];  // global max sum
        int maxNow = nums[0];  
        for (int i = 1; i < nums.length; i++) {
            maxNow = Math.max(maxNow + nums[i], nums[i]);
            max = Math.max(max, maxNow);
        }
        return max;
    }
}
