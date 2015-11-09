/* The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. */

public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) { return ""; }
        String prev = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            char digit = prev.charAt(0);
            int count = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == digit) { count++; }
                else {
                    cur.append(count).append(digit);
                    digit = prev.charAt(j);
                    count = 1;
                }
            }
            cur.append(count).append(digit);
            prev = cur.toString();
        }
        return prev;
    }
}
