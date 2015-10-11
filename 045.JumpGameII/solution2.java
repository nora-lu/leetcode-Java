public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) { return 0; }
        int curMax = 0, nextMax = 0, level = 0, i = 0;
        while (curMax - i + 1 > 0) {  //nodes count of current level>0
            level++;
            for ( ; i <= curMax; i++) {
                nextMax = Math.max(nextMax, i + nums[i]);  //traverse current level , and update the max reach of next level
            }
            if (nextMax >= nums.length - 1) { return level; }  // if last element is in level+1,  then the min jump=level
            curMax = nextMax;
        }
        return 0;
    }
}
