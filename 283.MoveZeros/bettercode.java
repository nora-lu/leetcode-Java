public class MoveZeros {
  public void moveZeros(int[] nums) {
    if (nums == null) { return; }
    int insertIdx = 0;
    for (int n : nums) {
      if (n != 0) { nums[insertIdx++] = n; }
    }
    // fill the remaining with zeros
    while (insertIdx < nums.length) { nums[insertIdx++] = 0; }
  }
}
