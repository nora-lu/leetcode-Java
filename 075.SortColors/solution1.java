public class Solution {
    public void sortColors(int[] nums) {
        int ctr0 = 0, ctr1 = 0, ctr2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { ctr0++; }
            if (nums[i] == 1) { ctr1++; }
            if (nums[i] == 2) { ctr2++; }
        }
        for (int i = 0; i < ctr0; i++) { nums[i] = 0; }
        for (int i = 0; i < ctr1; i++) { nums[ctr0 + i] = 1; }
        for (int i = 0; i < ctr2; i++) { nums[ctr0 + ctr1 + i] = 2; }
    }
}
