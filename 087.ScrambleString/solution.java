public class Solution {
  public boolean isScramble(String s1, String s2) {
    if (s1.equals(s2)) { return true; }
    if (s1.length() != s2.length()) { return false; }
    int[] chars = new int[256];
    int len = s1.length();
    for (int i = 0; i < len; i++) {
      chars[s1.charAt(i)]++;
      chars[s2.charAt(i)]--;
    }
    for (int count : chars) {
      if (count != 0) { return false; }
    }
    for (int i = 1; i <= len - 1; i++) {
      if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
          isScramble(s1.substring(i), s2.substring(i))) { return true; }
      if (isScramble(s1.substring(0, i), s2.substring(len - i)) &&
          isScramble(s1.substring(i), s2.substring(0, len - i))) {
          return true;
      }
    }
    return false;
  }
}
