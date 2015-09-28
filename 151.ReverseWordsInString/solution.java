public class ReverseWords {
  public String reverseWords(String s) {
    if (s == null) { return s; }
    s = s.trim();
    StringBuilder sb = new StringBuilder();
    int i = s.length() - 1;
    while (i >= 0) {
      while (i >= 0 && s.charAt(i) == ' ') { i--; }
      int j = i;
      while (j >= 0 && s.charAt(j) != ' ') { j--; }
      sb.append(s.substring(j + 1, i + 1));
      if (j > 0) { sb.append(" "); }
      i = j;
    }
    return sb.toString();
  }
}
