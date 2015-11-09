public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) { return 1; }
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        if (n % 2 == 0) {
            double sqrt = myPow(x, n / 2);
            return sqrt * sqrt;
        } else { return myPow(x, n - 1) * x; }
    }
}
