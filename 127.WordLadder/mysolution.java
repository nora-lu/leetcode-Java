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
