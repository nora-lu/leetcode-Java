/* Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false. */

public class WordSearch {
  private boolean[][] used;
  public boolean exist(char[][] board, String word) {
    if (board == null) { return false; }
    used = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (exist(board, word, i, j, 0)) { return true; }
      }
    }
    return false;
  }

  private boolean exist(char[][] board, String word, int i, int j, int start) {
    if (start == word.length()) { return true; }
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) { return false; }
    if (word.charAt(start) == board[i][j] && !used[i][j]) {
      used[i][j] = true;
      if (exist(board, word, i, j + 1, start + 1) || 
          exist(board, word, i, j - 1, start + 1) ||
          exist(board, word, i + 1, j, start + 1) ||
          exist(board, word, i - 1, j , start + 1)) { return true; }
      used[i][j] = false;
    }
    return false;
  }
}

