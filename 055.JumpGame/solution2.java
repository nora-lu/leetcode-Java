/* Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. */

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) { return true; }
        if (nums[0] == 0) { return false; }
        int maxJump = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump - 1, nums[i]);
            if (maxJump == 0) { return false; }
        }
        return true;
    }
}
