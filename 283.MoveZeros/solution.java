public class MoveZeros {
  public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) { return; }
        int nonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[i] != nums[nonZero]) {
                    swap(nums, i, nonZero);    
                }
                nonZero++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
