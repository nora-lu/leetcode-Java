public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        
        long rev = 0;
        int xCopy = x;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (int)rev == xCopy;
    }
}
