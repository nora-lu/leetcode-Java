public class ReverseInteger {
  private final int MAX_10 = Integer.MAX_VALUE / 10;
  public int reverse(int x) {
	int res = 0;
	while (x != 0) {
	  // if res > 214748364 or res < -214748364, then overflow  
    if (res > MAX_10 || res < -MAX_10) { return 0; }
    // if (res > MAX_10 || res < -MAX_10) { throw IllegalArgumentException("bad input"); }
    
    // IMPORTANT: if res = 214748364, last digit must be 1
    // if last digit is 2, the original number > Integer.MAX_VALUE
	  res = 10 * res + x % 10;
	  x = x / 10;
    }
    return res;
  }
}
