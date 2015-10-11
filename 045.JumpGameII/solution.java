public class Solution {
    public int jump(int[] nums) {
        if (nums == null) { return 0; }
        int jumps = 0, last = 0, cur = 0, n = nums.length;
        for (int i = 0 ; i < n; i++) {
            if (i > last) {
                jumps++;
                last = cur;
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return jumps;
    }
}
