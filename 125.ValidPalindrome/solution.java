public class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len < 2) return true;
        
        int i = 0, j = len - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) i++;
            if (i == j) return true;
            
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) j--;
            if (i == j) return true;
            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
