public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
	    if (tokens == null || tokens.length == 0) { return 0; }
	    Stack<Integer> stack = new Stack<>();
	    Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
	    for (String token : tokens) {
	      if (ops.contains(token)) {
	        int val2 = stack.pop();
	        int val1 = stack.pop();
	        if (token.equals("+")) { stack.push(val1 + val2); }
	        else if (token.equals("-")) { stack.push(val1 - val2); }
	        else if (token.equals("*")) { stack.push(val1 * val2); }
	        else { stack.push(val1 / val2); }
	      } else if (isInt(token)) {
	        int val = Integer.parseInt(token);
	        stack.push(val);
	      } 
	    }
	    return stack.pop();
	  }

	  private static boolean isInt(String str) {
	    for (char c : str.toCharArray()) {
	      if (c != '-' && c != '+' && !Character.isDigit(c)) { return false; }
	    }
	    return true;
	  }

	public static void main(String[] args) {
//		String[] tokens = new String[]{ "4","-2","/","2","-3","-","-" };
//		System.out.println(evalRPN(tokens));
		
	}

}
