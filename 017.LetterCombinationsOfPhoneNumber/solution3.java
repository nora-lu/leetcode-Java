public class Solution {
  private String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
  
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    recurse(digits.toCharArray(), new StringBuilder(), 0, res);
    return res;
  }

  private void recurse(char[] digits, StringBuilder cur, int start, List<String> res) {
    if (digits == null || digits.length == 0) { return; }
    if (start == digits.length) {
      res.add(cur.toString());
      return;
    }
    int digit = (int)(digits[start] - '0');
    for (char c : map[digit].toCharArray()) {
      cur.append(c);
      recurse(digits, cur, start + 1, res);
      cur.deleteCharAt(cur.length() - 1);
    }
  } 
}
