public class Solution {
    public int mySqrt(int x) {
        if (x == 0) { return 0; }
        int lo = 1, hi = x;
        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            if (mid <= x / mid) { lo = mid; }
            else { hi = mid; }
        }
        return lo;
    }
}
