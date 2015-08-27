public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;  // next positions to insert 0, 2.
        int i = zero;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                i++; zero++;
            } else if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
            } else { i++; }
        }
    }
    
    private void swap(int[] nums, int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
