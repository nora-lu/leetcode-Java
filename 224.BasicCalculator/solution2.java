public class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) { return 0; }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int sign = 1, ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') { continue; }
            if (c == '+') { sign = 1; }
            else if (c == '-') { sign = -1; }
            else if (c == '(') { 
                stack.push(sign * stack.peek()); 
                sign = 1;
            }
            else if (c == ')') { stack.pop(); }
            else {
                int number = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    number = 10 * number + s.charAt(i + 1) - '0';
                    i++;
                }
                ret += number * sign * stack.peek();
            }
        }
        return ret;
    }
}
