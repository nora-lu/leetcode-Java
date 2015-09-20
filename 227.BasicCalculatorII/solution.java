public class BasicCalculatorII {
  public int calculate(String s) {
    if (s == null) { return 0; }
    int len = s.length();
    Stack<Integer> stack = new Stack<>();
    
    int num = 0;
    char sign = '+';
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + (int)(c - '0');
      }
      if (i == len - 1 ||(!Character.isDigit(c) && c != ' ')) {
        if (sign == '+') { stack.push(num); }
        else if (sign == '-') { stack.push(-num); }
        else if (sign == '*') { stack.push(stack.pop() * num); }
        else if (sign == '/') { stack.push(stack.pop() / num); }
        sign = c;
        num = 0;
      }
    }
    int res = 0;
    for (int i : stack) { res += i; }
    return res;
  }
}
