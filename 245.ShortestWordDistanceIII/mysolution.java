public class ShortestWordDistance {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    int pos1 = -1, pos2 = -1, min = Integer.MAX_VALUE;
    boolean equal = word1.equals(word2), last = false;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        if (equal) {
          if (!last) { pos1 = i; last = true; }
          else { pos2 = i; last = false; }
        } else { pos1 = i; }
      } else if (words[i].equals(word2)) { pos2 = i; }
      if (pos1 != -1 && pos2 != -1) {
        min = Math.min(min, Math.abs(pos1 - pos2));
      }
    }
    return min;
  }
}
