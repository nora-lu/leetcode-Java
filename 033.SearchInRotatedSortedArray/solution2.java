public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    int minIdx = findMinIdx(nums);
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int realMid = (mid + minIdx) % nums.length;
      if (nums[realMid] == target) { return realMid; }
      if (nums[realMid] < target) { lo = mid + 1; }
      else { hi = mid - 1; }
    }
    return -1;
  }
  
  /**
   * General approach to find the index of smallest element in a rotated array.
   */
  private int findMinIdx(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] > nums[hi]) { lo = mid + 1; }
      else hi = mid;
    }
    return lo;
  }
}
