public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null) { return; }
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i - 1];
            if ((i % 2 == 1) == (tmp > nums[i])) {
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
