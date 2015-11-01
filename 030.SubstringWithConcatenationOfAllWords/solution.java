public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) { return ret; }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        
        int size = words.length, len = words[0].length();
        for (int j = 0; j < len; j++) {
            int start = j, count = 0;
            Map<String, Integer> window = new HashMap<>();
            for (int i = start; i <= s.length() - len; i += len) {
                String str = s.substring(i, i + len);
                if (map.containsKey(str)) {
                    window.put(str, window.containsKey(str) ? window.get(str) + 1 : 1);
                    count++;
                    while (window.get(str) > map.get(str)) {
                        String left = s.substring(start, start + len);
                        window.put(left, window.get(left) - 1);
                        count--;
                        start += len;
                    }
                    if (count == size) {
                        ret.add(start);
                        String left = s.substring(start, start + len);
                        window.put(left, window.get(left) - 1);
                        count--;
                        start += len;
                    }
                } else {
                    window.clear();
                    start = i + len;
                    count = 0;
                }
            }
        }
        return ret;
    }
}
