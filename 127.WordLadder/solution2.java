public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int len = 1;
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        
        while (!begin.isEmpty() && !end.isEmpty()) {
            boolean isBeginSmaller = begin.size() < end.size();
            // add new words to smaller set to achieve better performance
            Set<String> small = isBeginSmaller ? begin : end;
            Set<String> big = isBeginSmaller ? end : begin;
            Set<String> next = new HashSet<>();
            len++;
            for (String word : small) {
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, c);
                        String newWord = sb.toString();
                        if (big.contains(newWord)) { return len; }
                        if (!visited.contains(newWord) && wordList.contains(newWord)) {
                            visited.add(newWord);
                            next.add(newWord);
                        }
                    }
                }
            }
            if (isBeginSmaller) { begin = next; }
            else { end = next; }
        }
        return 0;
    }
}
