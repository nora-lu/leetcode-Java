/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"]. */

public class Solution {
    private Map<Character, Character> pairs = new HashMap<Character, Character>() {
        {
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }
    };
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int cur, int max) {
        List<String> res = new ArrayList<>();
        if (cur < 0) { return res; }
        
        if (cur == 0) { res.add(""); }
        else if (cur == 1) {
            for (char c : pairs.keySet()) {
                if (c == pairs.get(c)) { res.add(c + ""); }
            }
        } else {
            List<String> sub = helper(cur - 2, max);
            for (String str : sub) {
                for (Map.Entry<Character, Character> pair : pairs.entrySet()) {
                    char key = pair.getKey(), val = pair.getValue();
                    if (cur == max && key == '0') { continue; }
                    res.add(key + str + val);
                }
            }
            
        }
        return res;
    }
}
