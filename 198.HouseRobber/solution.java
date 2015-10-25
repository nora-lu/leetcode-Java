public class Solution {
    public int rob(int[] nums) {
        if (nums == null) { return 0; }
        
        int prevYes = 0;    // max monney can get if rob current house
        int prevNo = 0;     // max money can get if not rob current house
        for (int i = 0; i < nums.length; i++) {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to              // previous one.
            int curYes = nums[i] + prevNo;
            // If we don't rob current cell, then the count should be max of the previous cell robbed               // and not robbed
            int curNo = Math.max(prevYes, prevNo);
            
            prevYes = curYes;
            prevNo = curNo;
        }
        return Math.max(prevYes, prevNo);
        
        
        
        
//   if (nums == null || nums.length == 0) { return 0; }
//   int yesPrev = 0, noPrev = 0;
//   for (int i = 0; i < nums.length; i++) {
//     int tmp = yesPrev;
//     yesPrev = noPrev + nums[i];  // rob house i
//     noPrev = Math.max(tmp, noPrev);
//   }
//   return Math.max(yesPrev, noPrev);

    }
}
