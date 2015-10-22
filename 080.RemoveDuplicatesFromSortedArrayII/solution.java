/* Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. */

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
        
//   if (nums == null) { return 0; }
//   int newLen = -1, count = 0;
//   for (int i = 0; i < nums.length; i++) {
//     if (i > 0 && nums[i] == nums[newLen] && count == 2) { continue; }
//     if (i > 0 && nums[i] != nums[newLen]) { count = 1; }
//     else { count++; }
//     nums[++newLen] = nums[i];
//   }
//   return newLen + 1;

    }
}
