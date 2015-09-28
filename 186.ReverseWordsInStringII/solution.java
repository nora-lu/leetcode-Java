public class ReverseWordsII {
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1);
    int i = 0;
    while (i < s.length) {
      int j = i;
      while (j < s.length && s[j] != ' ') { j++; }
      reverse(s, i, j - 1);
      i = j + 1;
    }
  }
  
  private void reverse(char[] s, int lo, int hi) {
    if (lo >= hi) { return; }
    for (int i = lo; i <= lo + (hi - lo) / 2; i++) {
      char tmp = s[i];
      s[i] = s[hi + lo - i];
      s[hi + lo - i] = tmp;
    }
  }
}
