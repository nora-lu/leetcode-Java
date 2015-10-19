/* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. */

public class Solution {
  public List<String> wordBreak(String s, Set<String> wordDict) {
    if (s == null) { return null; }
    List<String> res = new ArrayList<>();
    int len = s.length();
    
    List<List<String>> dp = new ArrayList<>(); 
    for (int i = 0; i <= len; i++) { dp.add(new ArrayList<String>()); }
    dp.get(0).add("");
    for (int i = 1; i <= len; i++) {
      if (!containsSuffix(s.substring(i), wordDict)) { continue; }
      for (int j = 0; j < i; j++) {
        if (dp.get(j).size() > 0 && wordDict.contains(s.substring(j, i))) {
          List<String> list = dp.get(i);
          for (String str : dp.get(j)) {
            list.add(str + (str.length() == 0 ? "" : " ") + s.substring(j, i));
          }
        }
      }
    }
    return dp.get(len);
  }
  
  private boolean containsSuffix(String s, Set<String> dict) {
        if (s == null || s.length() == 0) { return true; }
		for (int i = 0; i < s.length(); i++) {
			if (dict.contains(s.substring(i))) { return true; }
		}
		return false;
	}
}
