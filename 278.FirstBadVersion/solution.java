/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(n, 1, n);
    }
    
    private int binarySearch(int n, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) { hi = mid; }
            else { lo = mid + 1; }
        }
        return lo;
    }
}
