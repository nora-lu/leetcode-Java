public class ThreeSumSmaller {
  public int threeSumSmaller(int[] nums, int target) {
    if (nums == null) { return 0; }
    
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      int lo = i + 1, hi = nums.length - 1;
      while (lo < hi) {
        if (nums[i] + nums[lo] + nums[hi] >= target) {
          while (lo < hi && nums[hi] == nums[hi - 1]) { hi--; }
          hi--;
        } else {
          res += (hi - lo);  // all k's: nums[i] + nums[lo] + nums[k] < target (lo < k <= hi)
          lo++;
        }
      }
    }
    return res;
  }
}
