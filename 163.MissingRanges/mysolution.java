public class MissingRanges {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      addRanges(res, lower, upper);
      return res;
    }
    
    int i = 0;
    if (lower < nums[i]) {
      addRanges(res, lower, nums[i] - 1);
    }
    while (i < nums.length - 1) {
      if (nums[i + 1] > nums[i] + 1) {
        addRanges(res, nums[i] + 1, nums[i + 1] - 1);
      }
      i++;
    }
    if (upper > nums[i]) {
      addRanges(res, nums[i] + 1, upper);
    }
    return res;
  }

  private void addRanges(List<String> res, int start, int end) {
    if (start == end) { res.add(String.valueOf(start)); }
    else { res.add(String.valueOf(start) + "->" + String.valueOf(end)); }
  }
}
