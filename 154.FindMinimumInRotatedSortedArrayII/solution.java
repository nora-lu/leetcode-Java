public class Solution {
    public int findMin(int[] nums) {
        if (nums == null) { return 0; }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) { hi = mid; }
            else if (nums[mid] > nums[hi]) { lo = mid + 1; }
            else { hi--; }  // we are not sure the position of minimum in mid's left or right
        }
        return nums[lo];
    }
    
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) { return nums[lo]; }
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] < nums[mid]) { lo = mid + 1; }
            else if (nums[lo] > nums[mid]) { hi = mid; }
            else { lo++; }
        }
        return nums[lo];
    }
}
