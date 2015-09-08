public class Solution {
    // public boolean isValid(String s) {
    //     if (s.length() % 2 != 0) return false; 
        
    //     ArrayList<Character> stack = new ArrayList<>();
    //     boolean result = true;
    //     int i = 0;
    //     while (result && i < s.length()) {
    //         Character c = s.charAt(i);
    //         if (c == '(' || c == '[' || c == '{') stack.add(c);
    //         else if (stack.size() > 0) {
    //             if (c == ')') result = stack.remove(stack.size() - 1).equals('(');
    //             else if (c == ']') result = stack.remove(stack.size() - 1).equals('[');
    //             else if (c == '}') result = stack.remove(stack.size() - 1).equals('{');
    //         }
    //         else result = false;
    //         i++;
    //     }
    //     return stack.size() == 0 && result;
    // }
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.empty() || map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.empty();
    }
}
