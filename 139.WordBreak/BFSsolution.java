/* Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". */

/* 思路：每个node是某个单词在s中出现的第一个字符位置index */

public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    if (s == null) { return true; }
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    Set<Integer> visited = new HashSet<>();  
    visited.add(0);

    while (!q.isEmpty()) {
      int idx = q.poll();
      for (int k = idx + 1; k <= s.length(); k++) {
        if (visited.contains(k)) { continue; }
        if (wordDict.contains(s.substring(idx, k))) {
          if (k == s.length()) { return true; }
          q.offer(k);
          visited.add(k);
        }
      }
    }
    return false;
  }
}
