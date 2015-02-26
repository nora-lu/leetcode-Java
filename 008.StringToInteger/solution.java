public class Solution {
    private static final int MAX_DEV_10 = Integer.MAX_VALUE / 10;
    
    public int atoi(String str) {
        int i = 0, n = str.length();
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        
        int flag = 1;
        if (i < n && str.charAt(i) == '+') i++;
        else if (i < n && str.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        
        int res = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (res > MAX_DEV_10 || (res == MAX_DEV_10 && digit >= 8)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return flag * res;
    }
}
