public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null) { return 0; }
        int lo = 0, hi = nums.length - 1;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) { lo = mid + 1; }
            else { hi = mid; }
        }
        return lo;
    }
}
