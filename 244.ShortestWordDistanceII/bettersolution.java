public class WordDistance {
  private Map<String, List<Integer>> map = new HashMap<>();

  public WordDistance(String[] words) {
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      List<Integer> list = map.get(word);
      if (list == null) {
        list = new ArrayList<Integer>();
      }
      list.add(i);
      map.put(word, list);
    }
  }
 
  /**
   * Use "SORTED" property of list1, list2. O(m + n) time.
   */
  public int shortest(String word1, String word2) {
    int min = Integer.MAX_VALUE;
    List<Integer> list1 = map.get(word1);
    List<Integer> list2 = map.get(word2);
    int i = 0, j = 0;
    while (i < list1.size() && j < list2.size()) {
      min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
      if (list1.get(i) < list2.get(j)) { i++; }
      else { j++; }
    }
    return min;
  }
}
