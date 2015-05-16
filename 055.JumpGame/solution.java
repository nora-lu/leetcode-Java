public class Solution {
    public boolean canJump(int[] nums) {
        for (int i = 0, maxReach = 0; i < nums.length && i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) { return true; }
        }
        return false;
    }
}
