public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) { return nums[0]; }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    
    private int helper(int[] nums, int start, int end) {
        int prevyes = 0, prevno = 0;
        for (int i = start; i <= end; i++) {
            int curyes = nums[i] + prevno;
            int curno = Math.max(prevyes, prevno);
            prevyes = curyes;
            prevno = curno;
        }
        return Math.max(prevyes, prevno);
    }
}
