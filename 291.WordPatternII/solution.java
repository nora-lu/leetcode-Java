/* Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters. */

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return match(pattern, 0, str, 0, map);
    }
    
    private boolean match(String pattern, int i, String str, int j, Map<Character, String> map) {
        if (i == pattern.length() && j == str.length()) { return true; }
        if (i == pattern.length() || j == str.length()) { return false; }
        
        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, j)) { return false; }
            return match(pattern, i + 1, str, j + s.length(), map);
        } else {
            for (int k = j; k < str.length(); k++) {
                String s = str.substring(j, k + 1);
                if (map.containsValue(s)) { continue; }
                map.put(c, s);
                if (match(pattern, i + 1, str, k + 1, map)) { return true; }
                map.remove(c);
            }
        }
        return false;
    }
}
