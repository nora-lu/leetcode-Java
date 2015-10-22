/* Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string. */

public class ReverseWords {
  public String reverseWords(String s) {
    if (s == null) { return s; }
    s = s.trim();
    StringBuilder sb = new StringBuilder();
    int i = s.length() - 1;
    while (i >= 0) {
      // skip spaces
      while (i >= 0 && s.charAt(i) == ' ') { i--; }
      // i is at non-space char now
      int j = i;
      while (j >= 0 && s.charAt(j) != ' ') { j--; }
       // j is either at space char or reaches -1 
      // we already trimmed leading spaces
      sb.append(s.substring(j + 1, i + 1));
      if (j > 0) { sb.append(" "); }  // do not forget to add a space between words
      i = j;
    }
    return sb.toString();
  }
}
