public class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }
    
    private int maxSubArray(int[] nums, int lo, int hi) {
        if (lo == hi) { return nums[lo]; }
        
        int mid = lo + (hi - lo) / 2;
        int leftMax = maxSubArray(nums, lo, mid);
        int rightMax = maxSubArray(nums, mid + 1, hi);
        
        int sum = 0;
        int leftSum = nums[mid];
        int rightSum = nums[mid + 1];
        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            if (sum > leftSum) { leftSum = sum; }
        }
        sum = 0;
        for (int i = mid + 1; i <= hi; i++) {
            sum += nums[i];
            if (sum > rightSum) { rightSum = sum; }
        }
        
        return Math.max(Math.max(leftMax, rightMax), leftSum + rightSum);
    }
}
