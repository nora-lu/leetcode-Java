public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two) { swap(nums, i, two--); }
            while (nums[i] == 0 && i > zero) { swap(nums, i, zero++); }
        }
    }
    
    private void swap(int[] nums, int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
