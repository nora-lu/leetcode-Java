/* Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters. */

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null) { return 0; }
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int s = 0; s < size; s++) {
                String word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    char[] chs = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        chs[i] = j;
                        String tmp = new String(chs);
                        if (tmp.equals(endWord)) { return level + 1; }
                        if (wordList.contains(tmp) && !visited.contains(tmp)) {
                            q.offer(tmp);
                            visited.add(tmp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
