public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
	    int res = 0, number = 0, sign = 1;
	    for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);
	      if (Character.isDigit(c)) { number = 10 * number + (int)(c - '0'); }
	      else if (c == '+' || c == '-') {
	        res += sign * number;
	        number = 0;
	        sign = c == '+' ? 1 : -1;
	      } else if (c == '(') {
	        stack.push(res);
	        stack.push(sign);
	        sign = 1;
	        res = 0;
	      } else if (c == ')') {
	        res += sign * number;
	        number = 0;
	        res *= stack.pop(); // last sign
	        res += stack.pop(); // last result
	      }
	    }
	    if (number != 0) res += sign * number;
	    return res;
    }
}
