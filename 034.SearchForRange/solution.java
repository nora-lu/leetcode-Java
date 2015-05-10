public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{ -1, -1 };
        if (nums == null || nums.length == 0) { return res; }
        int lo, hi, mid;
        
        // search for left bound
        lo = 0; 
        hi = nums.length - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) { lo = mid + 1; }
            else { hi = mid; }
        }
        if (nums[lo] != target) { return res; }
        else { res[0] = lo; }
        
        // search for right bound
        lo = 0; 
        hi = nums.length - 1;
        while (lo < hi) {
            mid = lo + (hi - lo + 1) / 2;
            if (nums[mid] > target) { hi = mid - 1; }
            else { lo = mid; }
        }
        if (nums[hi] != target) { return res; }
        else { res[1] = hi; }
        
        return res;
    }
}
