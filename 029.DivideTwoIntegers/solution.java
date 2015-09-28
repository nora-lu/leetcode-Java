public class DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    // special cases
    if (divisor == 0) { return Integer.MAX_VALUE; }
    if (divisor == -1 && dividend == Integer.MIN_VALUE) { return Integer.MAX_VALUE; }

    long pDividend = Math.abs((long)dividend);
    long pDivisor = Math.abs((long)divisor);

    int res = 0;
    while (pDividend >= pDivisor) {
      // calculate number of left shifts
      int shift = 0;
      while (pDividend >= (pDivisor << shift)) { shift++; }
      // dividend minus the largest shifted divisor
      res += 1 << (shift - 1);
      pDividend -= (pDivisor << (shift - 1));
    }
    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    return sign == 1 ? res : -res;
  }
}
