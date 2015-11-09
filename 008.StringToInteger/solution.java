/* Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned. */

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
