public class WordDictionary {
  private TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    if (word == null) { return; }
    TrieNode n = root;
    for (char c : word.toCharArray()) {
      int pos = c - 'a';
      if (n.children[pos] == null) {
        n.children[pos] = new TrieNode();
      }
      n = n.children[pos];
    }
    n.isWord = true;
  }
  

  public boolean search(String word) {
    return search(word, root);
  }

  private boolean search(String word, TrieNode node) {
        if (word == null) { return false; }
        /**
         * 注意这里的base case返回值
         */
        if (word.isEmpty()) { return node.isWord; }

        char first = word.charAt(0);
        if (first == '.') {
            for (TrieNode n : node.children) {
                if (n != null && search(word.substring(1), n)) { return true; }
            }
        } else {
            if (node.children[first - 'a'] == null) { return false; }
            else { return search(word.substring(1), node.children[first - 'a']); }
        }
        return false;
    }
}

class TrieNode {
  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];
  public TrieNode() {}
}
