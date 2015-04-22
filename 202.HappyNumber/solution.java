public class Solution {
    public boolean isHappy(int n) {
        for (int i = 0; i < 50; i++) {
            int sum = 0;
            while (n > 0) {
                sum = sum + (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
            if (n == 1) return true;
        }
        return false;
    }
}
