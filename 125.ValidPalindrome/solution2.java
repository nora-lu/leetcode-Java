public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        int lo = 0, hi = s.length() - 1;
        int check = 'a' - 'A';
        while (lo < hi) {
            while (lo < hi && !isValid(s.charAt(lo))) { lo++; }
            while (lo < hi && !isValid(s.charAt(hi))) { hi--; }
            if (s.charAt(lo) != s.charAt(hi) && Math.abs(s.charAt(lo) - s.charAt(hi)) != check) { return false; }
            lo++; hi--; 
        }
        return true;
    }

    public boolean isValid(char a) {
        return (a - 'A' >= 0 && a - 'Z' <= 0) || (a - 'a' >= 0 && a - 'z' <= 0) || (a - '0' >= 0 && a - '9' <= 0);
    }
}
