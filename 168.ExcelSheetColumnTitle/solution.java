public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
        
        // StringBuilder builder = new StringBuilder();
        // while (n > 0) {
        //     n--;  // pay attention to here
        //     builder.insert(0, (char) ('A' + n % 26));
        //     n /= 26;
        // }
        // return builder.toString();
    }
}
