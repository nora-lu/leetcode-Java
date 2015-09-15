public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) { return 0; }
        int min = nums.length + 1, left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            do {
                sum += nums[right++];
            } while (right < nums.length && sum < s);
            while (left < right && sum - nums[left] >= s) {
                sum -= nums[left++];
            }
            if (sum >= s) { min = Math.min(min, right - left); }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
