public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        if (lo >= hi) { return nums[lo]; }
        while (true) {
            int pos = partition(nums, lo, hi);
            if (pos == k - 1) { return nums[pos]; }
            else if (pos < k - 1) { lo = pos + 1; }
            else { hi = pos - 1; }
        }
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = nums[lo];
        while (true) {
            while (i < hi && nums[++i] > pivot);
            while (j > lo && nums[--j] < pivot);
            if (i >= j) { break; }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }
    
    private void exch(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
