public class MoveZeros {
  public void moveZeros(int[] nums) {
    if (nums == null) { return; }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int j = i + 1;
        while (j < nums.length && nums[j] == 0) { j++; }
        if (j < nums.length) {  // swap i, j
          nums[i] = nums[j];
          nums[j] = 0;
        }
      }
    }
  }
}
