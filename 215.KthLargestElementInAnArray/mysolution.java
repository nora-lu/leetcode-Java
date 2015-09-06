public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }
    
    private int findKthLargest(int[] nums, int k, int start, int end) {
        if (start >= end) { return nums[start]; }
        int j = partition(nums, start, end);
        if (j == k - 1) { return nums[j]; }
        else if (j < k - 1) { return findKthLargest(nums, k, j + 1, end); }
        else { return findKthLargest(nums, k, start, j - 1); }
        
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = nums[lo];
        while (true) {
            while (nums[++i] > pivot) {
                if (i == hi) { break; }
            }
            while (nums[--j] < pivot) {
                if (j == lo) { break; }
            }
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
