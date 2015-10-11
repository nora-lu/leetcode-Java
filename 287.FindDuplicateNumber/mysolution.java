/* Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once. */

public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) { return 0; }
        int n = nums.length - 1;
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int i : nums) {
                if (i <= mid) { count++; }
            }
            if (count > mid) { hi = mid; }
            else { lo = mid + 1; }
        }
        return lo;
    }
}
