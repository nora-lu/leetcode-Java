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

  private boolean search(String word, TrieNode n) {
    TrieNode tmp = n;
    if (word == null || word.equals("")) { return tmp.isWord; }
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == '.') {
        for (TrieNode t : tmp.children) {
          if (t != null && search(word.substring(i + 1), t)) { return true; }
        }
      } else {
        if (tmp.children[c - 'a'] == null) { return false; }
        return search(word.substring(i + 1), tmp.children[c - 'a']);
      }
    }
    return false;
  }
}

class TrieNode {
  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];
  public TrieNode() {}
}
