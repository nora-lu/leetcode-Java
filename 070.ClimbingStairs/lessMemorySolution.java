public class Solution {
    public int climbStairs(int n) {
        if (n <= 0 ) { return 0; }
        if (n <= 2) { return n; }
        
        int res = 0;
        int stepOne = 1, stepTwo = 1;
        for (int i = 2; i <= n; i++) {
            res = stepOne + stepTwo;
            stepTwo = stepOne;
            stepOne = res;
        }
        return res;
    }
}
