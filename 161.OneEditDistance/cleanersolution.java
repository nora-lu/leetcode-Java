public boolean isOneEditDistance(String s, String t) {
  int m = s.length(), n = t.length();
  for (int i = 0; i < Math.min(m, n); i++) {
    if (s.charAt(i) != t.charAt(i)) {
      return s.substring(i + (m >= n ? 1 : 0))
        .equals(t.substring(i + (m <= n ? 1 : 0)));
    }
  }
  return Math.abs(m - n) == 1;
}
