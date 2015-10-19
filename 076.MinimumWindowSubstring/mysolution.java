public class Solution {
    public String minWindow(String s, String t) {
        int ls = s.length(), lt = t.length();
        if (ls < lt) { return ""; }
        
        Map<Character, Integer> appear = new HashMap<>();
        Map<Character, Integer> require = new HashMap<>();
        for (char c : t.toCharArray()) {
            require.put(c, require.containsKey(c) ? require.get(c) + 1 : 1);
        }
        
        int start = 0, end = 0, count = 0;
        int minLen = Integer.MAX_VALUE, minStart = start;
        while (end < ls) {
            char c = s.charAt(end);
            if (require.containsKey(c)) {
                appear.put(c, appear.containsKey(c) ? appear.get(c) + 1 : 1);
                if (appear.get(c) <= require.get(c)) { count++; }
                if (count == lt) {  // find the window
                    // move start to right and find smaller window
                    while (start < end) {
                        char cs = s.charAt(start);
                        if (!require.containsKey(cs)) { start++; }
                        else {
                            if (appear.get(cs) > require.get(cs)) {
                                appear.put(cs, appear.get(cs) - 1);
                                start++;
                            } else { break; }
                        }
                    }
                    if (end - start + 1 < minLen) {
                        minLen = end - start + 1;
                        minStart = start;
                    }
                    appear.put(s.charAt(start), appear.get(s.charAt(start)) - 1);
                    start++; 
                    count--;
                }
            } 
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
