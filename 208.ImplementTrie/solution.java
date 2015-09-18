class TrieNode {
    private final int R = 26;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[R];
    // Initialize your data structure here.
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode n = root;
        for (Character ch : word.toCharArray()) {
            int pos = ch - 'a';
            if (n.children[pos] == null) {
                n.children[pos] = new TrieNode();
            }
            n = n.children[pos];
        }
        n.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode n = root;
        for (Character ch : word.toCharArray()) {
            if (n.children[ch - 'a'] == null) { return false; }
            n = n.children[ch - 'a'];
        }
        return n.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode n = root;
        for (Character ch : prefix.toCharArray()) {
            if (n.children[ch - 'a'] == null) { return false; }
            n = n.children[ch - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
