/* Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3. */

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] chars = new int[256];
        int max = 0, start = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
            if (chars[s.charAt(i)] == 1) { // new char
                count++;
                while (count > 2) {
                    chars[s.charAt(start)]--;
                    if (chars[s.charAt(start)] == 0) { count--; }
                    start++;
                }
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
