public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) { return true; }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) { map.put(c, 1); }
            else { map.put(c, map.get(c) + 1); }
        }
        int odd = 0;
        for (int val : map.values()) {
            if (odd > 1) { return false; }
            if (val % 2 != 0) { odd++; }
        }
        return odd <= 1;
    }
}
