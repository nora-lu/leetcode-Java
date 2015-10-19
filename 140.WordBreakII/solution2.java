public class Solution {
  private Map<String, List<String>> cache = new HashMap<>();

  public List<String> wordBreak(String s, Set<String> wordDict) {
    if (cache.containsKey(s)) { return cache.get(s); }
    List<String> res = new ArrayList<>();
    if (wordDict.contains(s)) { res.add(s); }
    for (int i = 1; i < s.length(); i++) {
      String left = s.substring(0, i), right = s.substring(i);
      if (wordDict.contains(left) && containsSuffix(right, wordDict)) {
        for (String str : wordBreak(right, wordDict)) {
          res.add(left + " " + str);
        }
      }
    }
    cache.put(s, res);
    return res;
  }

  private boolean containsSuffix(String s, Set<String> dict) {
    for (int i = 0; i < s.length(); i++) {
      if (dict.contains(s.substring(i))) { return true; }
    }
    return false;
  }
}
