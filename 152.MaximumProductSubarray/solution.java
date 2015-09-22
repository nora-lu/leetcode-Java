public class MaxProductSubarray {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) { return 0; }
    int maxPre = nums[0], minPre = nums[0], max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int maxNow = Math.max(Math.max(nums[i] * maxPre, nums[i] * minPre), nums[i]);
      int minNow = Math.min(Math.min(nums[i] * maxPre, nums[i] * minPre), nums[i]);
      max = Math.max(max, maxNow);
      maxPre = maxNow;
      minPre = minNow;
    }
    return max;
  }
}
