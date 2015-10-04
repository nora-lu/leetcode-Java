public class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> res = new LinkedList<>();
    if (digits == null || digits.length() == 0) { return res; }
    res.add("");
    String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    for (int i = 0; i < digits.length(); i++) {
      int digit = (int)(digits.charAt(i) - '0');
      int size = res.size();
      for (int j = 0; j < size; j++) {
        String pre = res.remove(0);
        for (char c : map[digit].toCharArray()) {
          res.add(pre + c);
        }
      }
    }
    return res;

  }
}
