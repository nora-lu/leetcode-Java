public int titleToNumber(String s) {
  int res = 0;
  for (char c : s.toCharArray()) {
    res = 26 * res + (int)(c - 'A') + 1;
  }
  return res;
}
