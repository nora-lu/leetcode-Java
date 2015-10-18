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
