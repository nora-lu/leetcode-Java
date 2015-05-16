public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, maxReach = 0;
        for (; i < nums.length && i <= maxReach && maxReach < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }
}
