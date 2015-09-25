public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) { return; }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
    }
}
