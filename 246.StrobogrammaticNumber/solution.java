public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put('1', '1');
                put('6', '9');
                put('8', '8');
                put('9', '6');
                put('0', '0');
            }
        };
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            if (!pairs.containsKey(c)) { return false; }
            if (pairs.get(c) != num.charAt(len - i - 1)) { return false; }
        }
        return true;
    }
}
