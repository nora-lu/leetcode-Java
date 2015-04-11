public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) return;
        
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] ar, int left, int right) {
        while (left < right) {
            int temp = ar[left];
            ar[left++] = ar[right];
            ar[right--] = temp;
        }
    }
}
