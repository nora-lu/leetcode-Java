public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i=0, j=0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
