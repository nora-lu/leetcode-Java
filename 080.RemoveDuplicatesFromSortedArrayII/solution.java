public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) { return 0; }
        
        int oldLen = nums.length;
        if (oldLen < 3) { return oldLen; }
        
        int newLen = 0, count = 1;
        for (int i = 1; i < oldLen; i++) {
            if (nums[i] == nums[newLen] && count < 2) {
                nums[++newLen] = nums[i];
                count++;
            } else if (nums[i] != nums[newLen]) {
                nums[++newLen] = nums[i];
                count = 1;
            }
        }
        return newLen + 1;
        
        // int newLen = 0;
        // for (int i = 1; i < oldLen; i++) {
        //     if (nums[i] == nums[newLen] && 
        //         (newLen > 0 && nums[newLen] == nums[newLen - 1])) { continue; }
        //     else { nums[++newLen] = nums[i]; }
        // }
        // return newLen + 1;
    }
}