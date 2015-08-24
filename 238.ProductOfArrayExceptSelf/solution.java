public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int p = 1;
        // Get the products below the current index
        for (int i = 0; i < nums.length; i++) {
            products[i] = p;
            p *= nums[i];
        }
        // Get the products above the curent index
        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] *= p;
            p *= nums[i];
        }
        return products;
    }
}
