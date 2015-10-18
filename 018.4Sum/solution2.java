public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null) { return null; }
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    if (n < 4) { return res; }
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();

    for (int i = 0; i < n - 3; i++) {
      for (int j = i + 1; j < n - 2; j++) {
        int lo = j + 1, hi = n - 1;
        int newTarget = target - nums[i] - nums[j];
        while (lo < hi) {
          if (nums[lo] + nums[hi] < newTarget) { lo++; }
          else if (nums[lo] + nums[hi] > newTarget) { hi--; }
          else {
            List<Integer> list = new ArrayList<Integer>(
              Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
            if (set.add(list)) { res.add(list); }
            lo++; hi--;
          }
        }
      }
    }
    return res;
  }
}
