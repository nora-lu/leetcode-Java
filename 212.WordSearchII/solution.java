public class WordSearchII {
  private Set<String> found = new HashSet<>();
  private boolean[][] used;
  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word : words) { trie.insert(word); }
	
    int m = board.length, n = board[0].length;
    used = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, "", i, j, trie);
      }
    }
    return new ArrayList<String>(found);
  }

  private void dfs(char[][] board, String s, int i, int j, Trie trie) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) { return; }
    if (used[i][j]) { return; }
    s += board[i][j];
    if (!trie.startsWith(s)) { return; }
    if (trie.search(s)) { found.add(s); }
    used[i][j] = true;
    dfs(board, s, i - 1, j, trie);
    dfs(board, s, i + 1, j, trie);
    dfs(board, s, i, j - 1, trie);
    dfs(board, s, i, j + 1, trie);
    used[i][j] = false;
  }
}

class TrieNode {
  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];
  public TrieNode() {}
}

class Trie {
  private TrieNode root;
  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
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
    TrieNode n = root;
    for (char c : word.toCharArray()) {
      int pos = c - 'a';
      if (n.children[pos] == null) { return false; }
      n = n.children[pos];
    }
    return n.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode n = root;
    for (char c : prefix.toCharArray()) {
      int pos = c - 'a';
      if (n.children[pos] == null) { return false; }
      n = n.children[pos];
    }
    return true;
  }
}
